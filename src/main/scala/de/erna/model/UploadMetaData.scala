package de.erna.model

import java.net.URI

import scala.beans.BeanProperty

case class UploadMetaData(@BeanProperty id: String, @BeanProperty targetUrl: URI)
