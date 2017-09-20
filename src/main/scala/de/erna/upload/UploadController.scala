package de.erna.upload

import javax.servlet.http.HttpServletRequest

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.{UploadAnnouncement, UploadConfirmation}
import de.erna.storage.StoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/upload"))
class UploadController( @Autowired val uploadPreparer: UploadPreparer,
                        @Autowired val storeService: StoreService ) extends LazyLogging {

  @PostMapping
  def upload( @RequestBody uploadAnnouncement: UploadAnnouncement ): UploadConfirmation = {
    logger.debug(s"An upload was announced: $uploadAnnouncement")
    uploadPreparer.prepareUpload(uploadAnnouncement)
  }

  @PostMapping( Array( "/{uploadId}" ) )
  def uploadFile( @PathVariable uploadId: String, request: HttpServletRequest ): String = {
    logger.debug( s"Upload started for blob $uploadId" )
    storeService.store( uploadId, request.getInputStream ).toString
  }
}
