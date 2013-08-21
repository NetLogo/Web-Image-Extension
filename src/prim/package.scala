package org.nlogo.extensions.webimage

import
  java.{ awt, io },
    awt.image.BufferedImage,
    io.ByteArrayOutputStream

import
  javax.imageio.ImageIO

package object prim {

  val DefaultEncoding    = "UTF-8"
  val DefaultImageFormat = "png"

  def using[A <: { def close() }, B](stream: A)(f: A => B) : B =
    try { f(stream) } finally { stream.close() }

  class EnhancedBufferedImage(image: BufferedImage) {
    def toByteArray: Array[Byte] = using(new ByteArrayOutputStream) {
      os =>
        ImageIO.write(image, DefaultImageFormat, os)
        os.toByteArray
    }
  }

  implicit def bi2Enhanced(image: BufferedImage) = new EnhancedBufferedImage(image)

}
