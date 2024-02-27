package domain

import domain.cart.Cart
import domain.movie.Movie
import domain.services.{CartService, MovieService, PricingService}
import infra.FileIO.{FileReader, FileWriter}
import infra.repositories.{CartRepository, MoviesRepository}

import scala.collection.immutable.{AbstractSeq, HashMap}

object CartApplication {
  println("Creating PricingService, reading input file and pricing the cart on the fly")
  private val pricingService = PricingService(
    getMovieService(),
    getCartService(),
    getPricingFun,
    getCartBuildingFun)
  
  println("Writing cart's price")
  pricingService.writePrice()
  

  def getPricingFun: AbstractSeq[Movie] => Int = {
    (moviesSeq: AbstractSeq[Movie]) => {
      val discountPerUniqueMovieInSaga: Map[Int, Double] = HashMap(1 -> 1.0, 2 -> 0.9, 3 -> 0.8).withDefaultValue(1.0)
      val priceIfMovieIsInSaga: Map[Boolean, Double] = HashMap(true -> 15.0, false -> 20.0).withDefaultValue(20.0)

      val nonDiscountedMovies = moviesSeq.filter(_.isEligibleToPromotion == false).toList
      val discountedMovies = moviesSeq.filter(_.isEligibleToPromotion == true).toList
      val nbOfDifferentDiscountedMovies = discountedMovies.distinct.length

      def pricePerTypeOfMovie(movies: List[Movie], isMovieInSaga: Boolean) =
        movies.length * priceIfMovieIsInSaga(isMovieInSaga)

      (
        pricePerTypeOfMovie(discountedMovies, true) * discountPerUniqueMovieInSaga(nbOfDifferentDiscountedMovies)
          + pricePerTypeOfMovie(nonDiscountedMovies, false)
        ).toInt
    }
  }

  def getCartBuildingFun: (AbstractSeq[Movie], AbstractSeq[Movie] => Int) => Cart =
    (
      moviesSeq: AbstractSeq[Movie],
      pricingFun: AbstractSeq[Movie] => Int
    ) =>
      Cart(
        moviesSeq.toList,
        CartApplication.getPricingFun(moviesSeq)
      )


  def getCartService(outputFileName:String = "output.txt"): CartService =
    CartService(CartRepository(FileWriter(outputFileName)))

  def getMovieService(inputFileName: String = "input.txt"): MovieService =
    MovieService(MoviesRepository(FileReader(inputFileName)))

}
