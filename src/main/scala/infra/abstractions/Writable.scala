package infra.abstractions

import domain.cart.Cart

import scala.util.Try

trait Writable {
  def writePrice(price: Int): Try[Unit]

}
