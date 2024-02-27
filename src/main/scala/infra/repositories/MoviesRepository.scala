package infra.repositories

import domain.movie.Movie
import infra.abstractions.Readable

import scala.collection.immutable.AbstractSeq

class MoviesRepository(reader: Readable) :
  def readMovies(): AbstractSeq[Movie] =
    reader.readMovies()


object MoviesRepository