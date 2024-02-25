package infra.abstractions

import domain.movie.Movie

trait Readable :
  def readMovies(): List[Movie]


