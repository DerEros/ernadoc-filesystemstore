package de.erna.metadata

import de.erna.model.UploadAnnouncement
import org.springframework.stereotype.Component

@Component
class BlobMetaDataDAO {

  def createBlobFromUpload( uploadMetaData: UploadAnnouncement ): Unit = {}
}
