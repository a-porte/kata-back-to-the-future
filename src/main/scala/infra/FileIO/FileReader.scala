package infra.FileIO

import domain.movie.Movie
import infra.abstractions.Readable

import scala.io.Source
import scala.util.Using

case class FileReader(fileName: String) extends Readable:
  override def readMovies(): List[Movie] =
    Using(Source.fromResource(fileName)) {
      _.getLines()
        .toList
        .filterNot(
          _.isEmpty
        )
        .map(
          Movie(_)
        )
    }.getOrElse(
      List[Movie]()
    )
