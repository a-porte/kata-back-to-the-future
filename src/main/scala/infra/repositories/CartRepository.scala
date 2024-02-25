package infra.repositories

import domain.cart.Cart

import scala.util.Try


class CartRepository:
  def writePrice(cart: Cart, inFileName: String): Try[Unit] =
    val path = os.Path

    Try(os.write(os.pwd / inFileName, cart.totalPrice.toString))

  

object CartRepository