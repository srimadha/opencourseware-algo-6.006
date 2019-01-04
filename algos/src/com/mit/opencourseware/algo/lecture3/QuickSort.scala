object QuickSort{

  def quickSort( arr : Array[Int] ) : Array[Int] = {

    if( arr.length <= 1)  arr

    else {
      val pivot = arr(arr.length / 2)

      Array.concat(
        quickSort(arr filter (pivot >)),
        arr filter (pivot ==),
        quickSort(arr filter (pivot <))
      )
    }
  }

  def main( args : Array[String]) {
    val random = scala.util.Random

    val arr = random.shuffle( 1 to 80) toArray
      val solved: Array[Int] = quickSort(arr)

    for( i <- 0 to arr.length - 1){
      print( arr(i) + ",");
    }
    println()
    for( i <- 0 to arr.length - 1){
      print( solved(i) + ",");
    }
  }
}