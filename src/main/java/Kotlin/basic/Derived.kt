package Kotlin.basic

/**
 *@Description:委托属性
 *@Author:TERRY_MENG
 *@Date:2018-07-03
 */

fun main(args: Array<String>) {
    val b=BaseImpl(5);
    Derived(b).printMessage()
    Derived(b).pirntMessageLine()
    val derived=Derived(b)
    print(derived.message)
}


interface Base{
    val message:String
    fun printMessage()
    fun pirntMessageLine()
}
class BaseImpl(val x:Int):Base{
    override val message: String
        get() = "BaseImpl:x=$x"

    override fun printMessage() {
        print(x)
    }

    override fun pirntMessageLine() {
        println(x)
    }

}

class Derived(b:Base) :Base by b{
    override val message: String
        get() = "Message of Derived"
    override fun printMessage() {
        print("abc")
    }
}
