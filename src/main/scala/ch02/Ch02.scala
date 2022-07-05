package ch02

import scala.collection.mutable

object Ch02:
  object Task1:
    def memoize[A, B](f: A => B): A => B =
      val map: mutable.Map[A, B] = mutable.Map()
      a => map.getOrElseUpdate(a, f(a))
