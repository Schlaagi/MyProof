package org.schlaagi.myproof.lambdaterm

class LambdaAbstraction(val variable: Variable, val term: LambdaTerm) : LambdaTerm {
    override val freeVariables: Set<Variable>
        get() = term.freeVariables.minus(variable)

    override fun renameVariable(old: Variable, new: Variable): LambdaTerm {
        if (old == variable) {
            return this
        }
        return LambdaAbstraction(variable, term.renameVariable(old, new))
    }

    override fun evaluate(): LambdaTerm {
        return LambdaAbstraction(variable, term.evaluate())
    }

    //TODO: Check
    override fun substitute(variableToSubstitute: Variable, substitutionTerm: LambdaTerm): LambdaTerm {
        if (variable == variableToSubstitute) {
            return this
        }
        if (substitutionTerm.freeVariables.contains(variable)) {
            val usedVariables = term.freeVariables.union(substitutionTerm.freeVariables)
            //Todo: Generate a new Variable
            val newVariable = Variable("fill in something here!")
            val renamedTerm = term.renameVariable(variable, newVariable)
            return LambdaAbstraction(newVariable, renamedTerm.substitute(variableToSubstitute, substitutionTerm))
        }
        return LambdaAbstraction(variable, term.substitute(variableToSubstitute, substitutionTerm))

    }

    override fun replace(variableToReplace: Variable, replacementTerm: LambdaTerm): LambdaTerm {
        return LambdaAbstraction(variableToReplace, term.replace(variableToReplace, replacementTerm))
    }

    override fun toString(): String {
        return "/\\$variable $term"
    }


}
