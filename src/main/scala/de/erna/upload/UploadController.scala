package de.erna.upload

import java.util
import javax.servlet.http.HttpServletRequest

import com.typesafe.scalalogging.LazyLogging
import de.erna.model.{UploadAnnouncement, UploadMetaData}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/upload"))
class UploadController(@Autowired val uploadPreparer: UploadPreparer) extends LazyLogging {

  @PostMapping
  def upload(@RequestBody uploadAnnouncement: UploadAnnouncement): UploadMetaData = {
    logger.debug(s"An upload was announced: $uploadAnnouncement")
    uploadPreparer.prepareUpload(uploadAnnouncement)
  }

  @PostMapping( Array( "/{blobId}" ) )
  def uploadFile( @PathVariable blobId: String, request: HttpServletRequest ): Unit = {
    val buffer = new Array[ Byte ]( 65535 )
    request.getInputStream.read( buffer )
    logger.info( s"Upload to id $blobId: ${util.Arrays.toString( buffer )}" )
  }
}
