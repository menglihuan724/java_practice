package Kotlin.basic
class X{
    private fun foo()=object {
        val x:Int=5
    }
     fun foo2()=object {
        val x:Int=5
    }
    fun bar(){
        val y=foo().x
        //val z=foo2().x
    }
}
object Test {
    fun testName(){

    }
    var name:String = ""
}
fun main(args: Array<String>) {
    var data1=Test
    var data2=Test
    data1.name="menglihuan"
    println("data1 name=${data2.name}")

}