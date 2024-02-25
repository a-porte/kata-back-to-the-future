package infra.repositories

import domain.CartHolder
import domain.movie.Movie
import infra.FileIO.FileWriter
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.funspec.AnyFunSpec

class CartRepositoryTest extends AnyFeatureSpec with GivenWhenThen {

  Feature("We want to write a price from a cart") {
    Scenario("We write it in a file") {
      val fileName = "output.txt"
      val cartToTest = CartHolder.cartFull
      Given(s"A cart with a price ${cartToTest.totalPrice} ")
      
      When("The CartRepository writes it")
      val maybeSuccess = CartRepository(FileWriter(fileName)).writePrice(cartToTest.totalPrice)
      
      Then("It creates a file successfully")
      assert(maybeSuccess.isSuccess)

    }
    
  }



}
