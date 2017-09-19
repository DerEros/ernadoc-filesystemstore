package de.erna.storage

import java.io.InputStream

import de.erna.model.UploadMetaData
import de.erna.storage.UploadState.UploadState

trait StoreService {
  def store( uploadMetaData: UploadMetaData, dataStream: InputStream ): UploadState

  def load( uploadMetaData: UploadMetaData ): Option[ InputStream ]
}
