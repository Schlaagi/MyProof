package org.schlaagi.myproof.lambdaterm

class Variable : LambdaTerm {
    override fun getFreeVariables(): Set<Variable> {
        return setOf(this)
    }

}
