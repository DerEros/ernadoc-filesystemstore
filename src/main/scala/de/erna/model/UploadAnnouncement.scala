package de.erna.model

import org.springframework.http.MediaType

import scala.beans.BeanProperty

case class UploadAnnouncement(@BeanProperty transferHost: String,
                              @BeanProperty sourceName: String,
                              @BeanProperty size: Long,
                              @BeanProperty mimeType: Option[MediaType]) {}
