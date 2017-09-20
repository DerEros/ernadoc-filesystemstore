package de.erna.upload

import com.typesafe.scalalogging.LazyLogging
import de.erna.metadata.UploadMetaDataDAO
import de.erna.model.{UploadAnnouncement, UploadConfirmation}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UploadPreparer(@Autowired uploadMetaDataDAO: UploadMetaDataDAO) extends LazyLogging {

  def prepareUpload( uploadAnnouncement: UploadAnnouncement ): UploadConfirmation = {
    logger.info(s"Preparing upload $uploadAnnouncement")

    val newUploadMetaData = uploadMetaDataDAO.createNewUploadMetaData( uploadAnnouncement )
    logger.debug(s"Prepared new ID for upload: ${newUploadMetaData.id}; Target URL: ${newUploadMetaData.targetUrl}")

    newUploadMetaData
  }
}
