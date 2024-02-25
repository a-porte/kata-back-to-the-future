package infra.repositories

import domain.movie.Movie

import scala.io.Source
import scala.util.{Try, Using}

object MoviesRepository {
  def readMovies(fileName: String): List[Movie] = {
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

  }

}
