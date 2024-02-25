package domain.cart

import domain.CartHolder
import domain.movie.Movie
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.propspec.AnyPropSpec

import scala.collection.immutable.HashMap

class CartTest extends AnyPropSpec with TableDrivenPropertyChecks{

 
  val carts = Table(
    ("moviesInCart", "totalPrice"),
    (CartHolder.cartFull, 36),
    (CartHolder.cartWithDuplicate, 48),
    (CartHolder.cartWithCopyCat, 56)
  )

  forAll(carts) { (cart, priceExpected) =>
    cart.totalPrice shouldBe priceExpected
  }
}

