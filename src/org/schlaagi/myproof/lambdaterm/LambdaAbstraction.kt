package org.schlaagi.myproof.lambdaterm

class LambdaAbstraction(val variable: Variable, val term: LambdaTerm) : LambdaTerm {
    override fun getFreeVariables(): Set<Variable> {
        return term.getFreeVariables().minus(variable)
    }

    override fun renameVariable(old: Variable, new: Variable): LambdaTerm {
        if(old == variable){
            return this
        }
        return LambdaAbstraction(variable, term.renameVariable(old, new))
    }

    override fun evaluate(): LambdaTerm {
        return Application(variable, term.evaluate())
    }

    override fun toString(): String {
        return "lambda ($variable) $term"
    }


}
