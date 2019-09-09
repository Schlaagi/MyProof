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
        println("Rename x to y in (x y): ${Application(x,y).renameVariable(x,y)}")

        val termToSubstitute = LambdaAbstraction(x, Application(y, x))
        println("Substitute of $termToSubstitute is ${termToSubstitute.substitute(y, x)}")
    }
}