package Kotlin.basic

/**
 *@Description:面向对象
 *@Author:TERRY_MENG
 *@Date:2018-06-12
 */
class Menglihuan(age:Int,height:Int){
    init {
        ("init start")
    }

    private val name="menglihuan"
    var age=age
     get() = field
     set(value) {
         if(value>27){
             field=27
         }else{
             field=value
         }
     }
    var height=height
        get() = field
        set(value) {
            if(value<165){
                field=field
            }else{
                field=value
            }
        }

    override fun toString(): String {
        return "Menglihuan(name='$name')"
    }
    inner  class mengSon{
        fun getOut(): String {
            val o=this@Menglihuan
            return o.name
        }
    }

}

fun main(args: Array<String>) {
    var menglihuan = Menglihuan(24, 160)
    menglihuan.age
    println(menglihuan.toString())
    println(menglihuan.mengSon().getOut())
}