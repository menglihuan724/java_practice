package Kotlin.basic

/**
 *@Description:
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */

interface Ma {
    fun foo(){
        print("A")
    }
    fun bar()
}
interface Mb {
    fun foo()
    fun bar() {
        print("B")
    }
}
class Mc: Ma, Mb {
    override fun bar() {
        super<Mb>.bar()
        print("c bar")
    }

    override fun foo() {
        super<Ma>.foo()
        print("c foo")
    }
}

fun main(args: Array<String>) {
    var myc= Mc()
    myc.bar()
    myc.foo()
}