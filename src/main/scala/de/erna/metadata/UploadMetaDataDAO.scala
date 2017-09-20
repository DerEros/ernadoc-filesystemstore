package de.erna.metadata

import java.net.URI
import java.util.UUID

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.{UploadAnnouncement, UploadConfirmation}
import org.springframework.stereotype.Component

@Component
class UploadMetaDataDAO extends LazyLogging {
  def createNewUploadMetaData( uploadAnnouncement: UploadAnnouncement ): UploadConfirmation = {
    //TODO: communicate with Meta Data store
    UploadConfirmation( mockUploadMetaDataId(),
                        uploadAnnouncement.uploadDescriptor.clientSideBlobId,
                        mockTargetUrl( mockUploadMetaDataId() ) )
  }

  //TODO: remove
  def mockUploadMetaDataId(): String = UUID.randomUUID().toString

  def mockTargetUrl(id: String): URI = new URI(s"http://store/blob/$id")

  def getUploadMetaData( uploadId: String ): Option[ UploadAnnouncement ] = {
    None
  }
}
