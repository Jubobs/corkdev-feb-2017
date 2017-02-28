package com.newsweaver.partitioning

final class Partitioner private(val numOfPartitions: Int) {

  def assign(n: Int): Int = math.abs(n) % numOfPartitions

}

object Partitioner {

  def apply(numOfPartitions: Int): Partitioner = {
    require(numOfPartitions > 0, "the number of partitions must be positive")
    new Partitioner(numOfPartitions)
  }

}