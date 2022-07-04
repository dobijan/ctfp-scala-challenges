package ch01

object Ch01:

  object Task1:
    def id[A](a: A): A = a

  object Task2:
    case class Composition[B, C](g: B => C):
      infix def <<[A](f: A => B): A => C = a => g(f(a))

    given functionToComposition[B, C]: Conversion[B => C, Composition[B, C]] with
      def apply(f: B => C): Composition[B, C] = Composition[B, C](f)
