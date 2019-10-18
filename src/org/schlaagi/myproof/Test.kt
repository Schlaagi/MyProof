package org.schlaagi.myproof

import org.schlaagi.myproof.church_numerals.churchify
import org.schlaagi.myproof.church_numerals.plus
import org.schlaagi.myproof.church_numerals.unchurchify
import org.schlaagi.myproof.lambdaterm.Application
import org.schlaagi.myproof.lambdaterm.LambdaAbstraction
import org.schlaagi.myproof.lambdaterm.Variable
import org.schlaagi.myproof.minimal_logic.Implication
import org.schlaagi.myproof.minimal_logic.inferFormula
import org.schlaagi.myproof.minimal_logic.isDerivationOf


object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = Variable("x")
        val y = Variable("y")
        val f = Variable("f")
        println("Variable x: $x")
        println("Application of f to x: ${Application(f, x)}")
        println("Application of f to x and y: ${Application(Application(f, x), y)}")
        println("Forall x y: ${LambdaAbstraction(x, y)}")
        println("Rename x to y in ${Application(f, x)}: ${Application(f, x).renameVariable(x, y)}")

        val termToSubstitute = LambdaAbstraction(x, Application(y, x))
//        println("Substitute of $termToSubstitute is ${termToSubstitute.substitute(y, x)}")


        // Church Numerals
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

        //Proof Checking
        val a = Variable("A")
        val b = Variable("B")
        val c = Variable("C")
        val u = Variable("U")
        val v = Variable("V")
        val w = Variable("W")
        val proposition =
            Implication(
                Implication(
                    a,
                    Implication(b, c)
                ),
                Implication(
                    Implication(a, b),
                    Implication(a, c)
                )
            )
        println(proposition)
        val term = LambdaAbstraction(
            u,
            LambdaAbstraction(
                v,
                LambdaAbstraction(
                    w,
                    Application(
                        Application(u, w),
                        Application(v, w)
                    )
                )
            )
        )
        println(term)
        val context = mapOf(
            u to Implication(a, Implication(b, c)),
            v to Implication(a, b),
            w to a
        )
        println(context)
        println(term.inferFormula(context))
        println(term.isDerivationOf(proposition, context))

    }
}
