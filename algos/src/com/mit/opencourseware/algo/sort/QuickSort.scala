object QuickSort{

  def quickSort[T]( arr : List[T], func: (T, T) => Int ) : List[T] = {
    if( arr.length <= 1) arr
    else {
      val pivot = arr(arr.length / 2)
      List.concat(
        quickSort(arr filter (func(_, pivot) == -1), func),
        arr filter (func(_, pivot) == 0),
        quickSort(arr filter (func(_, pivot) == 1), func)
      )
    }
  }

  def func( a : Int, b: Int) : Int = {
    if( a == b) return 0
    else if(a < b) return -1
    else return 1
  }

  def main( args : Array[String]) {
    val random = scala.util.Random
    val arr = random.shuffle( 1 to 80) toList
    val solved: List[Int] = quickSort(arr, func)

    arr.foreach( p => print(p + ","))
    println()
    solved.foreach( p => print(p + ","))
  }
}