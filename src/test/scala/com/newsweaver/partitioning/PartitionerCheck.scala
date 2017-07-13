package com.newsweaver.partitioning

import org.scalacheck.Gen._
import org.scalacheck.{Arbitrary, Properties}
import org.scalacheck.Prop.{forAll, throws}

object PartitionerCheck extends Properties("IntPartitioner") {

  property("The number of partitions must be positive") =
      forAll(nonpositiveInt) { numOfPartitions =>
        throws(classOf[IllegalArgumentException]) {
          Partitioner(numOfPartitions)
        }
      }

  property("'assign' returns a nonnegative integer smaller than the number of partitions") =
      forAll(positiveInt, int) { (numOfPartitions, n) =>
        val partitioner = Partitioner(numOfPartitions)
        val result = partitioner.assign(n)
        0 <= result && result < partitioner.numOfPartitions
      }

  private val int = Arbitrary.arbitrary[Int]

  private val nonpositiveInt = choose(Int.MinValue, 0)

  private val positiveInt = posNum[Int]

}