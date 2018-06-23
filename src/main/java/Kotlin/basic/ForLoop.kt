package Kotlin.basic


/**
 *@Description:基础语法
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */

fun main(args: Array<String>) {
    //字符模版
    var a="123"
    val s1="a is $a"
    println(s1)
    a="456"
    val s2="${s1.replace("is","was")},but now is $a"
    println(s2)
    //循环
    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
}