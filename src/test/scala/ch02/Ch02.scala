package ch02

import org.scalatest.flatspec.AnyFlatSpec

import org.scalatest.*
import matchers.should
import scala.util.Random

class Ch02Test extends AnyFlatSpec with should.Matchers {

  // Task 1 & Task 2
  "Memoized function" should "not repeat computation for same argument" in {
    // Arrange
    val f: Unit => Int = _ => new Random().nextInt()
    val memoF = Ch02.Task1.memoize(f)

    // Act
    val result1 = memoF(())
    val result2 = memoF(())

    // Assert
    result2 should be(result1)
  }

  // Task 3
  "Memoized random function with seed" should "repeat computation for different seeds" in {
    // Arrange
    val f: Int => Int = seed => new Random(seed).nextInt()
    val memoF = Ch02.Task1.memoize(f)

    // Act
    val result1 = memoF(1)
    val result2 = memoF(2)

    // Assert
    result2 should not be(result1)
  }
}
