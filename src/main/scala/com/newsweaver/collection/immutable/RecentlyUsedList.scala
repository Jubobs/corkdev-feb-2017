package com.newsweaver.collection.immutable

trait RecentlyUsedList[+A] extends PartialFunction[Int, A] {

  val capacity: Int

  def size: Int

  def isEmpty: Boolean = size == 0

  def +[B >: A](item: B): RecentlyUsedList[B]

  def clear: RecentlyUsedList[A]

  def toList: List[A]

}

object RecentlyUsedList {

  def apply[A](capacity: Int): RecentlyUsedList[A] =
    ListBasedRecentlyUsedList[A](capacity)

}
