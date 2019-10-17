package org.schlaagi.myproof

import org.schlaagi.myproof.church_numerals.churchify
import org.schlaagi.myproof.church_numerals.plus
import org.schlaagi.myproof.church_numerals.unchurchify
import org.schlaagi.myproof.lambdaterm.*

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = Variable("x")
        val y = Variable("y")
        println("Variable x: $x")
        println("Application of x to y: ${Application(x, y)}")
        println("Forall x y: ${LambdaAbstraction(x, y)}")
        println("Rename x to y in ${Application(x, y)}: ${Application(x, y).renameVariable(x, y)}")

        val termToSubstitute = LambdaAbstraction(x, Application(y, x))
//        println("Substitute of $termToSubstitute is ${termToSubstitute.substitute(y, x)}")

        val five = churchify(5)
        println(five)
        println(unchurchify(five))


        println()
        val plusOne = Application(plus, churchify(1))
        println(plusOne)
        println(plusOne.evaluate())
        println(plusOne.evaluate().evaluate())
        println()

        val two = Application(
            Application(plus, churchify(1)),
            churchify(1)
        )
        println(two)
        println(two.evaluate())
        println(two.evaluate().evaluate())
        println(two.evaluate().evaluate().evaluate())
    }
}