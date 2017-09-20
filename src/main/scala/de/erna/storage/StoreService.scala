package de.erna.storage

import java.io.InputStream

import de.erna.model.UploadConfirmation
import de.erna.storage.UploadState.UploadState

trait StoreService {
  def store( uploadId: String, dataStream: InputStream ): UploadState

  def load( uploadMetaData: UploadConfirmation ): Option[ InputStream ]
}
