package domain.services

import domain.cart.Cart
import infra.repositories.CartRepository

import scala.util.{Failure, Success, Try}
case class CartService(repo: CartRepository, cart: Cart ) :
  def writePrice(): Unit = writePrice(cart.totalPrice)
  def writePrice(price: Int): Unit = repo.writePrice(price) match
    case Failure(exception) => throw Exception(exception)
    case Success(value) => println("Wrote the price successfully")


