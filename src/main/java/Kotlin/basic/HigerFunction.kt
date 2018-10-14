package Kotlin.basic

/**
 *@Description:高级方法
 *@Author:TERRY_MENG
 *@Date:2018-07-03
 */
fun main(args: Array<String>) {
    testRun()
    testApply()
    testLet()
    testAlso()
    testWith()

}
fun testRun(){
    val a=run{
        println("run")
        return@run 10
    }
    println(a)
}

fun testApply(){
    val b="testApply".apply{
        println(this)
    }
}

fun testLet(){
    val c="testLet".let {
        println(it)
    }
}

fun testAlso(){
    val d="testIt".also {
        println(it)
    }
}

fun  testWith(){
    val e= with("testWith"){
        println(this)
    }
}