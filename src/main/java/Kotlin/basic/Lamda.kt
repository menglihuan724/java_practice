package Kotlin.basic

/**
 *@Description:lamda表达式
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */

fun main(args: Array<String>) {
     val sumlamda:(Int,Int)->Int={x,y->x+y}
    println(sumlamda(7,24))

    val items= listOf(1,2,3,4,6)
    items.fold(0) { acc:Int,i:Int->
        print("acc=$acc,i=$i, ")
        val result=acc+i
        println("result=$result")
        result
    }
    val joinedToString=items.fold("Elements") { acc, i-> "$acc $i" }
    val product=items.fold(1,Int::times)
    println(joinedToString)
    println(product)


    val repeat:String.(Int)->String={times->repeat(times)}
    fun runTransformation(f:(String,Int)->String):String{
        return f("fuck you\n",3)
    }
    val result=runTransformation(repeat)
    print(result)

    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(4.intPlus(3)) // 类扩展调用


    var sum = 0
    items.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)
}

fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

