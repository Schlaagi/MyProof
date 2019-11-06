package org.schlaagi.myproof.church_numerals

import org.schlaagi.myproof.lambdaterm.Application
import org.schlaagi.myproof.lambdaterm.LambdaAbstraction
import org.schlaagi.myproof.lambdaterm.LambdaTerm
import org.schlaagi.myproof.lambdaterm.Variable

fun churchify(number: Int): LambdaTerm {
    val variable = Variable("x")
    val function = Variable("f")
    return LambdaAbstraction(function, LambdaAbstraction(variable, applyRecursively(function, variable, number)))

}

fun applyRecursively(function: LambdaTerm, variable: Variable, numberOfTimes: Int): LambdaTerm {
    if (numberOfTimes > 0) {
        return Application(function, applyRecursively(function, variable, numberOfTimes - 1))
    }
    return variable
}

fun unchurchify(churchNumeral: LambdaTerm): Int {
    if (churchNumeral is LambdaAbstraction) {
        val f = churchNumeral.variable
        if (churchNumeral.term is LambdaAbstraction) {
            val x = churchNumeral.term.variable
            return unchirchifyRec(f, x, churchNumeral.term.term)
        }
    }
    throw IllegalArgumentException()
}

//ToDo: Rename
fun unchirchifyRec(f: Variable, x: Variable, term: LambdaTerm): Int {
    if (term == x) {
        return 0
    }
    if (term is Application && term.first == f) {
        return unchirchifyRec(f, x, term.second) + 1
    }
    throw IllegalArgumentException()
}


val plus: LambdaTerm
    get() {
        val m = Variable("m")
        val n = Variable("n")
        val f = Variable("f0")
        val x = Variable("x0")
        return LambdaAbstraction(
            m,
            LambdaAbstraction(
                n,
                LambdaAbstraction(
                    f,
                    LambdaAbstraction(
                        x,
                        Application(
                            Application(m, f),
                            Application(
                                Application(n, f),
                                x
                            )
                        )
                    )
                )
            )
        )
    }