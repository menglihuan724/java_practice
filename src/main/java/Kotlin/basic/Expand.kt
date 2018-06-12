package Kotlin.basic

class MY{
    companion object { }
}
fun Any?.toString():String{
    if(this ==null){
        return  "null"
    }
    return toString()
}
fun MY.Companion.foo(){
    println("companion object method")
}
val MY.Companion.ob:Int
    get() = 24

open class D{
}

open class D1:D(){

}
open class C{
    open fun D.bar(){
        println("D in C")
    }
    open fun D1.bar(){
        println("D1 in c")
    }
    fun caller(d:D){
        d.bar()
    }
}
class C1:C(){
    override fun D.bar(){
        println("D in c1")
    }
    override fun D1.bar(){
        println("D1 in c1")
    }


}
fun main(args: Array<String>) {
    var x=null
    println(x.toString())
    MY.Companion.foo()
    println(MY.Companion.ob)
    C().caller(D())
    C1().caller(D())
    C().caller(D1())
}

