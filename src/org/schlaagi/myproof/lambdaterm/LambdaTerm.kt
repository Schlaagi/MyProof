package org.schlaagi.myproof.lambdaterm

interface LambdaTerm {
    fun getFreeVariables(): Set<Variable>

    fun renameVariable(old: Variable, new: Variable): LambdaTerm

    fun evaluate(): LambdaTerm

    fun substitute(variable: Variable, term: LambdaTerm): LambdaTerm{return this}
}
