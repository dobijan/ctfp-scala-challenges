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
      a.zip("x" * a.length)
        .map { case (a, b) => s"$a$b" }
        .mkString
        .dropRight(1)

    import Ch01.Task2.given

    val composed = function2 << function1

    // Act
    val result = composed(input)

    // Assert
    result should be("CxTxFxP")
  }

  // Task 3
  "The composition function" should "respect left identity" in {
    // Arrange
    val input = "ctfp"

    val function1 = (a: String) => a.toUpperCase

    import Ch01.Task2.given

    val composed = Ch01.Task1.id << function1

    // Act
    val result = composed(input)

    // Assert
    result should be("CTFP")
  }

  "The composition function" should "respect right identity" in {
    // Arrange
    val input = "ctfp"

    val function1 = (a: String) => a.toUpperCase

    import Ch01.Task2.given

    val composed = function1 << Ch01.Task1.id[String]

    // Act
    val result = composed(input)

    // Assert
    result should be("CTFP")
  }
}
