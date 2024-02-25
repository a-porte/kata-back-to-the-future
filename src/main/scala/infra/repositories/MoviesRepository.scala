package infra.repositories

import domain.movie.Movie

import infra.abstractions.Readable

class MoviesRepository(reader: Readable) :
  def readMovies(): List[Movie] =
    reader.readMovies()


object MoviesRepository