package org.schlaagi.myproof.lambdaterm

interface LambdaTerm {
    fun getFreeVariables(): Set<Variable>
}
