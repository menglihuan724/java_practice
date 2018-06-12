package Kotlin.basic

data class User(val name: String, val age: Int)

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

fun main(args: Array<String>) {
    var meng=User("meng",27)
    var mengson=meng.copy("smallmeng",1)
    println(meng)
    println(mengson)
    val(name,age)=meng
    println("$name,$age")
    println(eval(Const(5.0)))
}