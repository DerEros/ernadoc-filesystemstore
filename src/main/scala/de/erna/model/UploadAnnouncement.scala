package de.erna.model

import scala.beans.BeanProperty

case class UploadAnnouncement( @BeanProperty grabberDescriptor: GrabberDescriptor,
                               @BeanProperty uploadDescriptor: UploadDescriptor,
                               @BeanProperty id: String,
                               @BeanProperty version: String ) extends Document( id, version, "UploadAnnouncement" )
