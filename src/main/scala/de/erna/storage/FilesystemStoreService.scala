package de.erna.storage

import java.io.InputStream
import java.nio.file.Files

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.UploadMetaData
import de.erna.storage.UploadState.UploadState
import org.springframework.stereotype.Component

@Component
class FilesystemStoreService extends StoreService with LazyLogging {
  override def store( uploadMetaData: UploadMetaData, dataStream: InputStream ): UploadState = {
    logger.debug( s"Storing $uploadMetaData" )

    Files.copy( dataStream, Files.createTempDirectory( "upload" ).resolve( uploadMetaData.id ) )

    UploadState.FINISHED
  }

  override def load( uploadMetaData: UploadMetaData ): Option[ InputStream ] = None
}
