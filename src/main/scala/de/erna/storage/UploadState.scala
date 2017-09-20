package de.erna.storage

object UploadState extends Enumeration {
  type UploadState = Value
  val AWAITING, IN_PROGRESS, FINISHED, FAILED = Value
}
