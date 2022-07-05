package ch04

object Ch04:
  object Task1:
    // we reuse Scala's Option type
    case class OptionKleisliOps[A, B](k1: A => Option[B]):
      infix def >=>[C](k2: B => Option[C]): A => Option[C] =
        a =>
          for {
            b <- k1(a)
            c <- k2(b)
          } yield c
    object OptionKleisliOps:
      def identity[A](a: A): Option[A] = Option(a)
    given functionToKleisli[A, B]
        : Conversion[A => Option[B], OptionKleisliOps[A, B]] = OptionKleisliOps(
      _
    )
  object Task2:
    def safeReciprocal(value: Double): Option[Double] =
      Option(value).filterNot(_ == 0).map(1 / _)
    def safeRoot(value: Double): Option[Double] =
      Option(value).filter(_ >= 0).map(Math.sqrt(_))
  object Task3:
    val safeRootReciprocal: Double => Option[Double] =
      import Ch04.Task1.given
      Task2.safeReciprocal >=> Task2.safeRoot
