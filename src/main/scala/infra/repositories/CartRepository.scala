package infra.repositories

import domain.cart.Cart
import infra.abstractions.Writable

import scala.util.Try


class CartRepository(writer: Writable):
  def writePrice(price: Int): Try[Unit] =
    writer.writePrice(price)

object CartRepository