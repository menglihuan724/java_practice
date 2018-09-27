package Kotlin.basic

import kotlin.coroutines.experimental.buildSequence

/**
 *@Description:协程
 *@Author:TERRY_MENG
 *@Date:2018-07-03
 */

fun main(args: Array<String>) {
    val fibonacciSeq= buildSequence {
        var a=0
        var b=1
        yield(1)
        while (true){
            yield(a+b)
            val temp=a+b
            a=b
            b=temp
        }
    }
    println(fibonacciSeq.take(8).toList())
    val lazySeq= buildSequence{
        print("start")
        for(i in 1..24){
            yield(i)
            print("step")
        }
        print("end")
        yieldAll(25..27)
    }
  lazySeq.take(27).forEach{ print("$it")}
}