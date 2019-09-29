package org.schlaagi.myproof.lambdaterm

//ToDo: gescheite Namen für die Parameter
class Application(val first: LambdaTerm, val second: LambdaTerm) : LambdaTerm {
    override val freeVariables: Set<Variable>
        get() = first.freeVariables.union(second.freeVariables)

    override fun renameVariable(old: Variable, new: Variable): LambdaTerm {
        return Application(first.renameVariable(old, new), second.renameVariable(old, new))
    }

    override fun evaluate(): LambdaTerm {
        if (first is LambdaAbstraction) {
            return second.substitute(first.variable, first.term).evaluate()
        }
        return Application(first.evaluate(), second.evaluate())
    }

    override fun substitute(variableToSubstitute: Variable, substitutionTerm: LambdaTerm): LambdaTerm {
        return Application(
            first.substitute(variableToSubstitute, substitutionTerm),
            second.substitute(variableToSubstitute, substitutionTerm)
        )
    }

    override fun replace(variableToReplace: Variable, replacementTerm: LambdaTerm): LambdaTerm {
        return Application(
            first.replace(variableToReplace, replacementTerm),
            second.replace(variableToReplace, replacementTerm)
        )
    }

    //Todo: Klammern möglicherweise überflüssig für Types. Könnten dann entfernt werden
    override fun toString(): String {
        return "($first $second)"
    }

}
