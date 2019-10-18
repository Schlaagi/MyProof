package org.schlaagi.myproof.scheme_helper

import org.schlaagi.myproof.lambdaterm.Application
import org.schlaagi.myproof.lambdaterm.LambdaAbstraction
import org.schlaagi.myproof.lambdaterm.Variable
import org.schlaagi.myproof.minimal_logic.Implication

/**
 * A list of scheme helper functions, can hopefolly deleted soon
 * car: list.get(0)
 * cdr: list.drop(1)
 * cadr: list.get(1)
 * caddr: list.get(2)
 * ...
 * caadr: list<list>.get(1).get(0)
 *
 */

val Variable.car get() = this
val Application.car get() = first
val Application.cadr get() = second
val Implication.cadr get() = antecedent
val LambdaAbstraction.caddr get() = term
val LambdaAbstraction.caadr get() = variable
