package Kotlin.basic

import java.util.*


/**
 *@Description:基础语法
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */

fun main(args: Array<String>){
    val arry1= arrayOf(1,2,3)
    val arry2=Array(3,{i->(i*2)})
    println(Arrays.toString(arry1))
    println(Arrays.toString(arry2))

    val text="""
        |123
        |345
        |789
        |   10,10,21
        """.trimMargin()
    println(text)

    //if else
    val x=0
    val y=2
    val z=if (x>y) x else y
    println(z)

    //when
    testWhen("123")
    testWhen(123)
    testWhen(2)
    testWhen(2.5)

    for ((index,value) in arry2.withIndex()){
        println("index$index:value$value")
    }

    testReturn(arry2)
}

fun testWhen(params:Any){
    when(params){
         is String -> println("String")
         is Int -> println(1)
         in 2..10-> println("2 to 10")
        else-> println("nonthing")
    }
}

fun testReturn(ints:Array<Int>){

    ints.forEach lit@ {
        if (it == 0) return@lit
        print("返回的值$it")
    }
//    (
//
//           fun(value: Int) {
//        if (value == 0) return
//        print("返回的值$value")
//    }
//    )
}