package org.nlogo.extensions.webimage

import
  org.nlogo.api.{ DefaultClassManager, PrimitiveManager }

import
  prim._

class WebImageExtension extends DefaultClassManager {
  def load(primitiveManager: PrimitiveManager) {
    primitiveManager.addPrimitive("get-view-bytes",      GetViewBytes)
    primitiveManager.addPrimitive("get-interface-bytes", GetInterfaceBytes)
    primitiveManager.addPrimitive("base64-encode",       Base64Encode)
    primitiveManager.addPrimitive("base64-decode",       Base64Decode)
  }
}

