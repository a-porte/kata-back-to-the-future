package domain.movie

case class Movie(title: String):
  private val eligibilityRegex = """Back to the Future [1-3]"""
  val isEligibleToPromotion: Boolean = title matches(eligibilityRegex)
