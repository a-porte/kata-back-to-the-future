package domain.services

import domain.cart.Cart
import domain.movie.Movie
import infra.repositories.{CartRepository, MoviesRepository}

import scala.collection.immutable.AbstractSeq

case class PricingService(private val movieRepo: MoviesRepository,
                          private val cartRepo: CartRepository,
                          pricingFun: AbstractSeq[Movie] => Int,
                          cartBuildingFun: (AbstractSeq[Movie], AbstractSeq[Movie] =>Int) => Cart
                         ):
  val movieService: MovieService = MovieService(movieRepo)
  val cartService: CartService = CartService(cartRepo, cartBuildingFun(movieService.movies, pricingFun))

  def writePrice(): Unit = cartService.writePrice(priceCart)

  def priceCart: Int = pricingFun(movieService.movies)
