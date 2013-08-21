package org.nlogo.extensions.webimage.prim

import
  org.apache.commons.codec.binary.Base64

import
  org.nlogo.api.{ Argument, Context, DefaultReporter, Syntax },
    Syntax.{ StringType, WildcardType }

object Base64Decode extends DefaultReporter {
  override def getSyntax = Syntax.reporterSyntax(Array(StringType), WildcardType)
  override def report(args: Array[Argument], context: Context): AnyRef =
    Base64.decodeBase64(args(0).getString.getBytes(DefaultEncoding))
}
