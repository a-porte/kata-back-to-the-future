package domain.cart

import domain.movie.Movie

import scala.collection.immutable.{AbstractSeq, HashMap}

case class Cart(movies: List[Movie], totalPrice: Int= 0)

