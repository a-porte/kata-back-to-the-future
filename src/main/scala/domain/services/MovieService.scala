package domain.services

import domain.movie.Movie
import infra.repositories.MoviesRepository

import scala.collection.immutable.AbstractSeq

case class MovieService(repo: MoviesRepository):
  val movies: AbstractSeq[Movie] = readMovies
  private def readMovies: AbstractSeq[Movie] = repo.readMovies()
