package domain.movie

import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.propspec.AnyPropSpec

class MovieTest extends AnyPropSpec with TableDrivenPropertyChecks{
  val movies = Table(
    ("moviename", "is eligible to reduction"),
    (Movie("Back to the Future 1"), true),
    (Movie("La chèvre"), false)
  )

  forAll(movies) {(movie, expectation) =>
    movie.isEligibleToPromotion shouldBe expectation
  }
}
