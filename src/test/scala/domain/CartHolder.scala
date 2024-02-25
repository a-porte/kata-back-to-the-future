package domain

import domain.cart.Cart
import domain.movie.Movie

object CartHolder {  
  private val fullSaga = (1 to 3).map(i =>Movie(s"Back to the Future $i")).toList
  private val fullSagaWithDuplicate = fullSaga :+ Movie("Back to the Future 1")
  private val sagaWithCopyCat = fullSaga :+ Movie("Rick and Morty")

  val cartFull: Cart = Cart(fullSaga)
  val cartWithDuplicate: Cart = Cart(fullSagaWithDuplicate)
  val cartWithCopyCat: Cart = Cart(sagaWithCopyCat)


}
