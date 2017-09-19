package de.erna.metadata

import java.net.URI
import java.util.UUID

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.UploadMetaData
import org.springframework.stereotype.Component

@Component
class UploadMetaDataDAO extends LazyLogging {
  def createNewUploadMetaData(): UploadMetaData = {
    //TODO: communicate with Meta Data store
    UploadMetaData(mockUploadMetaDataId(), mockTargetUrl(mockUploadMetaDataId()))
  }

  //TODO: remove
  def mockUploadMetaDataId(): String = UUID.randomUUID().toString

  def mockTargetUrl(id: String): URI = new URI(s"http://store/blob/$id")
}
