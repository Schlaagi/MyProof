package org.schlaagi.myproof.lambdaterm

interface LambdaTerm {
    //ToDo: make real getter
    fun getFreeVariables(): Set<Variable>

    fun renameVariable(old: Variable, new: Variable): LambdaTerm

    fun evaluate(): LambdaTerm

    fun substitute(variableToSubstitute: Variable, substitutionTerm: LambdaTerm): LambdaTerm

    fun replace(variableToReplace: Variable, replacementTerm: LambdaTerm): LambdaTerm
}
