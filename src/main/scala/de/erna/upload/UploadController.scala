package de.erna.upload

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.{UploadAnnouncement, UploadMetaData}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping(Array("/upload"))
class UploadController(@Autowired val uploadPreparer: UploadPreparer) extends LazyLogging {

  @RequestMapping(method = Array(RequestMethod.POST, RequestMethod.GET))
  def upload(@RequestBody uploadAnnouncement: UploadAnnouncement): UploadMetaData = {
    logger.debug(s"An upload was announced: $uploadAnnouncement")
    uploadPreparer.prepareUpload(uploadAnnouncement)
  }
}
