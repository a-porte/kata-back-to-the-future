package infra.FileIO

import infra.abstractions.Writable

import scala.util.Try

case class FileWriter(fileName: String) extends Writable:
  override def writePrice(price: Int): Try[Unit] =
    val path = os.Path

    Try(os.write.over(os.pwd / fileName, price.toString))
