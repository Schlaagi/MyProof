package org.schlaagi.myproof.minimal_logic

import org.schlaagi.myproof.lambdaterm.Application
import org.schlaagi.myproof.lambdaterm.LambdaAbstraction
import org.schlaagi.myproof.lambdaterm.LambdaTerm
import org.schlaagi.myproof.lambdaterm.Variable

//ToDo: consider implementing this directly in LambdaTerm

fun LambdaTerm.inferFormula(context: Map<Variable, Formula>): Formula {
    return when (this) {
        is Variable -> context.getValue(this)
        is Application -> inferFormula(context) //ToDo return third argument
        is LambdaAbstraction -> Implication(
            variable.inferFormula(context),
            term.inferFormula(context)
        )
        else -> throw IllegalArgumentException("How can this happen?")
    }
}

fun Application.inferFormula(context: Map<Variable, Formula>): Formula {
    val formula1 = first.inferFormula(context)
    val formula2 = second.inferFormula(context)
    if(formula1 is Implication && formula1.antecedent == formula2){
        return formula1.consequent
    }
    throw IllegalArgumentException("$this is not a valid Formula with context $context")
}

// Todo: Remove this function if it is not needed (I dont think it is)
fun LambdaTerm.isDerivationOf(formula: Formula, context: Map<Variable, Formula>): Boolean {
    return try{
        inferFormula(context) == formula
    }
    catch(e: IllegalArgumentException){
        false
    }

}

