package domain.cart

import domain.movie.Movie

import scala.collection.immutable.HashMap

case class Cart(private val movies: List[Movie]):
  def totalPrice: Int =
    (
      pricePerTypeOfMovie(discountedMovies, true) * discountPerUniqueMovieInSaga(nbOfDifferentDiscountedMovies)
        + pricePerTypeOfMovie(nonDiscountedMovies, false)
      ).toInt

  private def pricePerTypeOfMovie(movies: List[Movie], isMovieInSaga: Boolean) =
    movies.length * priceIfMovieIsInSaga(isMovieInSaga)


  private val nonDiscountedMovies = movies.filter(_.isEligibleToPromotion == false)
  private val discountedMovies = movies.filter(_.isEligibleToPromotion == true)
  private val nbOfDifferentDiscountedMovies = discountedMovies.distinct.length

  private val discountPerUniqueMovieInSaga: Map[Int, Double] = HashMap(1 -> 1.0, 2 -> 0.9, 3 -> 0.8).withDefaultValue(1.0)
  private val priceIfMovieIsInSaga: Map[Boolean, Double] = HashMap(true -> 15.0, false -> 20.0).withDefaultValue(20.0)

