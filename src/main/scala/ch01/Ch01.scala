package ch01

object Ch01:

  object Task1:
    def id[A](a: A): A = a

  object Task2:
    case class Composition[A, B](f: A => B):
      infix def <<[C](g: B => C): A => C = a => g(f(a))

    given functionToComposition[A, B]: Conversion[A => B, Composition[A, B]] with
      def apply(f: A => B): Composition[A, B] = Composition[A, B](f)
