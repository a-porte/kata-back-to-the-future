package domain.services

import domain.CartApplication
import domain.cart.Cart
import domain.movie.Movie
import infra.FileIO.{FileReader, FileWriter}
import infra.repositories.{CartRepository, MoviesRepository}
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

import scala.collection.immutable.{AbstractSeq, HashMap}


class PricingServiceTest extends AnyFeatureSpec with GivenWhenThen {
  Feature("We want to price a cart with the rules given in the kata") {
    Scenario("One movie costs €20 except for a Back to the future sage (15€), plus a discount exists") {
      val inputFile = "input.txt"
      val pricingService = PricingService(
        CartApplication.getMovieService("inputTest.txt"),
        CartApplication.getCartService("outputTest.txt"),
        CartApplication.getPricingFun,
        CartApplication.getCartBuildingFun)

      Given(s"A the $inputFile file which is read")

      When("we price the cart on the fly")

      Then("it gives the right cost and writes the output file accordingly")
      pricingService.writePrice()
      assert(pricingService.cart.totalPrice == 56)
      assert(os.exists(os.pwd / "outputTest.txt"))
    }

  }



}
