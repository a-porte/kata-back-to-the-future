package domain.services

import domain.cart.Cart
import domain.movie.Movie

import scala.collection.immutable.AbstractSeq

case class PricingService(movieService: MovieService,
                          cartService: CartService, 
                          pricingFun: AbstractSeq[Movie] => Int,
                          cartBuildingFun: (AbstractSeq[Movie], AbstractSeq[Movie] =>Int) => Cart
                         ):
  val cart: Cart = cartBuildingFun(movieService.movies, pricingFun)

  def writePrice(): Unit = cartService.writePrice(priceCart)

  private def priceCart = pricingFun(cart.movies)
