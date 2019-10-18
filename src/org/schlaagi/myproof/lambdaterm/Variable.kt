package org.schlaagi.myproof.lambdaterm

import org.schlaagi.myproof.minimal_logic.Formula

data class Variable(val name: String) : LambdaTerm, Formula{
    override val freeVariables: Set<Variable>
        get() = setOf(this)

    //ToDo: Acutally replaces the Variable, maybe it would make more sense to just change its name?
    override fun renameVariable(old: Variable, new: Variable): LambdaTerm {
        if (this == old) {
            return new
        }
        return this
    }

    override fun evaluate(): LambdaTerm {
        return this
    }

    override fun substitute(variableToSubstitute: Variable, substitutionTerm: LambdaTerm): LambdaTerm {
        if (this == variableToSubstitute) {
            return substitutionTerm
        }
        return this
    }

    override fun replace(variableToReplace: Variable, replacementTerm: LambdaTerm): LambdaTerm {
        if (this == variableToReplace) {
            return replacementTerm
        }
        return this
    }

    override fun toString(): String {
        return name
    }

}
