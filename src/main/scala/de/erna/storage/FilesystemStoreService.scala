package de.erna.storage

import java.io.InputStream
import java.nio.file.Files

import com.typesafe.scalalogging.LazyLogging
import de.erna.metadata.UploadMetaDataDAO
import de.erna.model.UploadConfirmation
import de.erna.storage.UploadState.UploadState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FilesystemStoreService @Autowired()( uploadMetaDataDAO: UploadMetaDataDAO )
  extends StoreService with LazyLogging {
  override def store( uploadId: String, dataStream: InputStream ): UploadState = {
    logger.debug( s"Storing $uploadId" )

    val uploadMetaData = uploadMetaDataDAO.getUploadMetaData( uploadId )
    Files.copy( dataStream, Files.createTempDirectory( "upload" ).resolve( uploadId ) )

    UploadState.FINISHED
  }

  override def load( uploadMetaData: UploadConfirmation ): Option[ InputStream ] = None
}
