package org.schlaagi.myproof

import org.schlaagi.myproof.lambdaterm.*

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = Variable("x")
        val y = Variable("y")
        println("Variable x: $x")
        println("Application of x to y: ${Application(x,y)}")
        println("Forall x y: ${LambdaAbstraction(x,y)}")
    }
}
