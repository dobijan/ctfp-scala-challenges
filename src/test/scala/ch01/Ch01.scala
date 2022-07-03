package ch01

import org.scalatest._
import flatspec._
import matchers._
import scala.language.implicitConversions

class Ch01Test extends AnyFlatSpec with should.Matchers {

  "The identity function" should "return its input" in {
    // Arrange
    val input = "ctfp"

    // Act
    val result = Ch01.Task1.id(input)

    // Assert
    result should be(input)
  }

  "The composition function" should "compose 2 functions in correct order" in {
    // Arrange
    val input = "ctfp"
    val function1 = (a: String) => a.toUpperCase
    val function2 = (a: String) =>
      a.zip("-" * a.length)
        .map { case (a, b) => s"$a$b" }
        .mkString
        .dropRight(1)

    import Ch01.Task2.functionToComposition

    val composed = function2 << function1

    // Act
    val result = composed(input)

    // Assert
    result should be("C-T-F-P")
  }
}
