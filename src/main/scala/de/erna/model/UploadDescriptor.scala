package de.erna.model

import scala.beans.BeanProperty

case class UploadDescriptor( @BeanProperty clientSideBlobId: String,
                             @BeanProperty sourceName: String,
                             @BeanProperty size: Long,
                             @BeanProperty mimeType: Option[ String ] )
