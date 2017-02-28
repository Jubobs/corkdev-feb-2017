package com.newsweaver.partitioning

import org.scalatest.FunSuite

final class IntPartitionerTest extends FunSuite {

  test("The number of partitions must be positive") {
    val nonpositiveInt = -1

    intercept[IllegalArgumentException] {
      Partitioner(nonpositiveInt)
    }
  }

  test("'assign' returns a nonnegative integer smaller than the number of partitions") {
    val numOfPartitions = 3
    val partitioner = Partitioner(numOfPartitions)

    val result = partitioner.assign(42)

    0 <= result && result < numOfPartitions
  }

}
