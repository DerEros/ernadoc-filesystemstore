package de.erna.upload

import java.net.URI
import javax.servlet.http.HttpServletRequest

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.{UploadAnnouncement, UploadMetaData}
import de.erna.storage.StoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/upload"))
class UploadController( @Autowired val uploadPreparer: UploadPreparer,
                        @Autowired val storeService: StoreService ) extends LazyLogging {

  @PostMapping
  def upload(@RequestBody uploadAnnouncement: UploadAnnouncement): UploadMetaData = {
    logger.debug(s"An upload was announced: $uploadAnnouncement")
    uploadPreparer.prepareUpload(uploadAnnouncement)
  }

  @PostMapping( Array( "/{blobId}" ) )
  def uploadFile( @PathVariable blobId: String, request: HttpServletRequest ): String = {
    logger.debug( s"Upload started for blob $blobId" )
    storeService.store( UploadMetaData( "fooid", new URI( "foouri" ) ), request.getInputStream ).toString
  }
}
