package infra.abstractions

import domain.movie.Movie

import scala.collection.immutable.AbstractSeq

trait Readable :
  def readMovies(): AbstractSeq[Movie]


