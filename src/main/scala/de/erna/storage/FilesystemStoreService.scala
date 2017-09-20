package de.erna.storage

import java.io.InputStream
import java.nio.file.Files

import com.typesafe.scalalogging.LazyLogging
import de.erna.metadata.{BlobMetaDataDAO, UploadMetaDataDAO}
import de.erna.model.{UploadAnnouncement, UploadConfirmation}
import de.erna.storage.UploadState.UploadState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FilesystemStoreService @Autowired()( uploadMetaDataDAO: UploadMetaDataDAO, blobMetaDataDAO: BlobMetaDataDAO )
  extends StoreService with LazyLogging {

  override def store( uploadId: String, dataStream: InputStream ): UploadState = {
    logger.debug( s"Storing $uploadId" )

    val uploadMetaDataOption = uploadMetaDataDAO.getUploadMetaData( uploadId )

    //TODO: log error if no meta data is found
    uploadMetaDataOption.map( doStore( uploadId, dataStream, _ ) ) getOrElse UploadState.FAILED
  }

  private def doStore( uploadId: String,
                       dataStream: InputStream,
                       uploadMetaData: UploadAnnouncement ): UploadState = {
    try {
      Files.copy( dataStream, Files.createTempDirectory( "upload" ).resolve( uploadId ) )

      blobMetaDataDAO.createBlobFromUpload( uploadMetaData )

      UploadState.FINISHED
    } catch {
      case e: Throwable =>
        logger.debug( "Upload failed", e )
        UploadState.FAILED
    }
  }

  override def load( uploadMetaData: UploadConfirmation ): Option[ InputStream ] = None
}
