def s = "la"
def str1 = 2
def str2 = 4
println(add(str1,str2))
println(add3(9))
println "Hello World! $s"

println("list")
//list不会下标越界
def xzList = [1,"d"]
xzList[6]=10
println(xzList)
//list可以加减
println(xzList+[190])
println(xzList-[1,10])
println(xzList[8])
xzList.each {print(" $it")}

println("map")
def xzMap = [1:1,2:2,"s":3]
//函数调用可以省略括号
println xzMap
println(xzMap.s)
println(xzMap["s"])

println("range")
def xzRange = 1..6
println(xzRange)
//方法最后一个参数为闭包时,闭包可以省略括号
xzRange.each{print(it-10) }
println("等同于")
xzRange.each({print(it-10) })
println()
for(i in 1..4){print(" $i")}
//当闭包没有显式给出参数时,有一个it参数,类似java的this
2.upto(4){print(" $it")}
0.step(10,2){print(" $it")}
println()

println("closure")
//闭包,实际上类似python的方法参数可以为方法(高阶函数)
def xzClosure = {a,b -> a*b}
println(xzClosure.call(9,10))
//法最后一个参数为闭包可以省略括号,但是前面的参数需要括号
println doSomething("New York ",3){a->
    println("where am I ,$a ?")
}


def s3 = new Song()
s3.name = "Funkytown"
s3.artist = "Lipps Inc."
s3.setGenre("Disco")
println(s3)
s3.artist=null
//?.的意思是,如果不为空,执行后面语句
println(s3.artist?.toUpperCase())

//"<<"可以是list,set的add方法,流的write方法,把闭包赋值给变量
xzList << 2**3//幂运算
println(xzList)
xzClosure<<{println("hello,<<")}
xzClosure(1,3)

//不写return的话,最后一行默认返回
static def add(a, b){ a+b }
//默认参数
static def add3(a, b=3){ a+b }
static def doSomething(a, b, Closure clo){
    clo.call(a)
    a+b
}

class Song {
    def name
    def artist
    def genre
    String toString(){
        "${name}, ${artist}, ${genre}"
    }
}