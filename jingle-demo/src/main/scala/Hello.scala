/**
  * Created by Jinhua on 2017/3/24.
  */
object Hello {
  def main(args: Array[String]): Unit = {
    println(add(b=1))
    runFor(2)
    runFor()
    println(add1(1))
  }

  //最后一行默认返回
  def add(a: Int = 0, b: Int = -1):Int = {
    a + b
  }

  //似乎有推断返回值的能力,
  def add1(a: Int = 0) = {
    "sum is "+ (a + 1)
  }

  def runFor()={
    for(i <- 0 to 10){
      println(i)
    }
  }

  def runFor(a:Int){
    for(i <- 0 to 10
    if a<10 && i%a==0){
      printf("10以内可以被%d整除的数: %s\n",a,i)
    }
  }
}
