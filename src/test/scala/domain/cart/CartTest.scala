package domain.cart

import domain.movie.Movie
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.propspec.AnyPropSpec

import scala.collection.immutable.HashMap

class CartTest extends AnyPropSpec with TableDrivenPropertyChecks{

  val fullSaga = (1 to 3).map(i =>Movie(s"Back to the Future $i")).toList
  val fullSagaWithDuplicate = fullSaga :+ Movie("Back to the Future 1")
  val sagaWithCopyCat = fullSaga :+ Movie("Rick and Morty")

  val carts = Table(
    ("moviesInCart", "totalPrice"),
    (Cart(fullSaga), 36),
    (Cart(fullSagaWithDuplicate), 48),
    (Cart(sagaWithCopyCat), 56)
  )

  forAll(carts) { (cart, priceExpected) =>
    cart.totalPrice shouldBe priceExpected
  }
}

