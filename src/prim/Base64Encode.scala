package org.nlogo.extensions.webimage.prim

import
  java.awt.image.BufferedImage

import
  org.apache.commons.codec.binary.Base64

import
  org.nlogo.api.{ Argument, Context, DefaultReporter, ExtensionException, LogoList, Syntax },
    Syntax.{ StringType, WildcardType }

object Base64Encode extends DefaultReporter {

  override def getSyntax = Syntax.reporterSyntax(Array(WildcardType), StringType)

  override def report(args: Array[Argument], context: Context): AnyRef = {

    val bytes = (args(0).get match {
      case s:     String        => Option(s.getBytes(DefaultEncoding))
      case arr:   Array[Byte]   => Option(arr)
      case list:  LogoList      => listToByteArrayOpt(list)
      case image: BufferedImage => Option(image.toByteArray)
      case _                    => None
    }) getOrElse (
      throw new ExtensionException("Unable to encode whatever this thing is: %s\n\nPlease try a string, list of bytes, or `BufferedImage`.".format(args(0).get.toString))
    )

    Base64.encodeBase64String(bytes)

  }

  private def listToByteArrayOpt(list: LogoList): Option[Array[Byte]] =
    try Option(list.toVector.toArray map (_.asInstanceOf[Double].toByte))
    catch { case ex: Exception => None }

}
