package org.schlaagi.myproof.lambdaterm

class LambdaAbstraction(val variable: Variable, val term: LambdaTerm) : LambdaTerm {
    override fun getFreeVariables(): Set<Variable> {
        return term.getFreeVariables().minus(variable);
    }
}
