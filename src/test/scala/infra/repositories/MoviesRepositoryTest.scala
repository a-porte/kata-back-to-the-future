package infra.repositories

import domain.movie.Movie
import infra.FileIO.{FileReader, FileWriter}
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.funspec.AnyFunSpec

class MoviesRepositoryTest extends AnyFeatureSpec with GivenWhenThen {

  Feature("We want to create a cart") {
    Scenario("We read the cart from a file") {
      val fileName = "input.txt" 
      Given(s"A file named $fileName located in the resources folder")
      
      When("The MovieRepository reads it")
      val readMovies= MoviesRepository(FileReader(fileName)).readMovies()
      
      Then("It creates a non empty list")
      assert(readMovies.nonEmpty) 
      
    }
    
  }



}
