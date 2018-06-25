package Kotlin.basic

/**
 *@Description:继承接口等
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */

open class A {
    open val x=1
    open var y=5
    open fun f () { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } //接口的成员变量默认是 open 的
    fun b() { print("b") }
}

class C2(override var y:Int) : A() , B {
    override var x=2
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

fun main(args: Array<String>) {
    val c = C2(7)
    c.f();
    println(c.x)
    println(c.y)

}