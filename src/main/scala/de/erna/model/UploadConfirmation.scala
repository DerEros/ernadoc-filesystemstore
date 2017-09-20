package de.erna.model

import java.net.URI

import scala.beans.BeanProperty

case class UploadConfirmation( @BeanProperty id: String,
                               @BeanProperty clientSideBlobId: String,
                               @BeanProperty targetUrl: URI )
