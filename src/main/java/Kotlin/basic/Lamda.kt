package Kotlin.basic

/**
 *@Description:lamda表达式
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */

fun main(args: Array<String>) {
     val sumlamda:(Int,Int)->Int={x,y->x+y}
    println(sumlamda(7,24))
}