package ch04

import org.scalatest.flatspec.AnyFlatSpec

import org.scalatest.*
import matchers.should
import scala.util.Random

class Ch04Test extends AnyFlatSpec with should.Matchers {

  // Task 1

  "Composition of partial functions" should "return empty if first result is empty" in {
    // Arrange
    val f1: String => Option[Int] = _ => Option.empty
    val f2: Int => Option[String] = nr => Option(nr.toString())

    import Ch04.Task1.given
    val composed = f1 >=> f2

    // Act
    val result = composed("ctfp")

    // Assert
    result should be(Option.empty)
  }

  "Composition of partial functions" should "return empty if second result is empty" in {
    // Arrange
    val f1: String => Option[Int] = s => Option(s.length())
    val f2: Int => Option[String] = _ => Option.empty

    import Ch04.Task1.given
    val composed = f1 >=> f2

    // Act
    val result = composed("ctfp")

    // Assert
    result should be(Option.empty)
  }

  "Composition of partial functions" should "work as normal composition in case both functions return values" in {
    // Arrange
    val f1: String => Option[Int] = s => Option(s.length())
    val f2: Int => Option[String] = nr => Option(nr.toString())

    import Ch04.Task1.given
    val composed = f1 >=> f2

    // Act
    val result = composed("ctfp")

    // Assert
    result should be(Option("4"))
  }

  // Task 2

  "Safe reciprocal" should "return empty given 0" in {
    // Arrange
    val input = 0

    // Act
    val result = Ch04.Task2.safeReciprocal(input)

    // Assert
    result should be(Option.empty)
  }

  "Safe reciprocal" should "return reciprocal given nonzero input" in {
    // Arrange
    val input = 2

    // Act
    val result = Ch04.Task2.safeReciprocal(input)

    // Assert
    result should be(Option(0.5))
  }

  // Task 3

  "Safe root reciprocal" should "return empty on negative input" in {
    // Arrange
    val input = -1

    // Act
    val result = Ch04.Task3.safeRootReciprocal(input)

    // Assert
    result should be(Option.empty)
  }

  "Safe root reciprocal" should "return empty on zero input" in {
    // Arrange
    val input = 0

    // Act
    val result = Ch04.Task3.safeRootReciprocal(input)

    // Assert
    result should be(Option.empty)
  }

  "Safe root reciprocal" should "return square root of reciprocal for positive input" in {
    // Arrange
    val input = 4

    // Act
    val result = Ch04.Task3.safeRootReciprocal(input)

    // Assert
    result should be(Option(0.5))
  }
}
