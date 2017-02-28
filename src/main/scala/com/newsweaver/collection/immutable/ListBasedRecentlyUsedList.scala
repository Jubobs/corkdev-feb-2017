package com.newsweaver.collection.immutable

private[immutable] final class ListBasedRecentlyUsedList[+A](
    val capacity: Int,
    val size: Int,
    list: List[A]
) extends PartialFunction[Int, A]
    with RecentlyUsedList[A] {

  def +[B >: A](item: B): RecentlyUsedList[B] = {
    require(item != null)

    list match {
      case Nil => ListBasedRecentlyUsedList.singleton(capacity, item)
      case h :: t =>
        if (item == h) {
          this
        } else if (t contains item) {
          val updatedList = item :: h :: (t diff List(item))
          new ListBasedRecentlyUsedList[B](capacity, size, updatedList)
        } else {
          val updatedSize = math.min(size + 1, capacity)
          val updatedList = item :: list.take(capacity - 1)
          new ListBasedRecentlyUsedList[B](capacity, updatedSize, updatedList)
        }
    }
  }

  def clear: RecentlyUsedList[A] = ListBasedRecentlyUsedList.empty[A](capacity)

  def toList: List[A] = list

  override def apply(index: Int): A = list(index)

  override def isDefinedAt(index: Int) = 0 <= index && index < size

  override def toString: String = list.mkString("RecentlyUsedList(", ", ", ")")

}

object ListBasedRecentlyUsedList {

  def apply[A](capacity: Int): RecentlyUsedList[A] = {
    require(capacity > 0, "nonpositive capacity")
    empty[A](capacity)
  }

  private def singleton[A](capacity: Int, item: A) =
    new ListBasedRecentlyUsedList[A](capacity, 1, List(item))

  private def empty[A](capacity: Int) =
    new ListBasedRecentlyUsedList[A](capacity, 0, Nil)

}
