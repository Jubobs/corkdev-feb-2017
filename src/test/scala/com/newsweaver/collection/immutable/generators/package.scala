package com.newsweaver.collection.immutable

import org.scalacheck.Arbitrary._
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Gen._

package object generators {

  object Ints {

    val int: Gen[Int] = Arbitrary.arbitrary[Int]

    val positiveInt: Gen[Int] = posNum[Int]

    val negativeInt: Gen[Int] = negNum[Int]

    val nonpositiveInt: Gen[Int] = frequency((1, 0), (9, negativeInt))

    val nonnegativeInt: Gen[Int] = frequency((1, 0), (9, positiveInt))

  }

  object Strings {

    val string: Gen[String] = arbitrary[String]

    val setOfStrings: Gen[Set[String]] = containerOf[Set, String](string)

    val nonEmptySetOfStrings: Gen[Set[String]] =
      nonEmptyContainerOf[Set, String](string)

    val setOfAtLeastTwoStrings: Gen[Set[String]] =
      setOfStrings suchThat { _.size >= 2 }

  }

}
