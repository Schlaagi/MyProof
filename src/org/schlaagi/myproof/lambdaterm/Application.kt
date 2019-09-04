package org.schlaagi.myproof.lambdaterm

//ToDo: gescheite Namen für die Parameter
class Application(val first: LambdaTerm, val second: LambdaTerm) : LambdaTerm {
    override fun getFreeVariables(): Set<Variable> {
        return first.getFreeVariables().union(second.getFreeVariables())
    }

    override fun renameVariable(old: Variable, new: Variable): LambdaTerm {
        return Application(first.renameVariable(old, new), second.renameVariable(old, new))
    }

    //Todo: Klammern möglicherweise überflüssig für Types. Könnten dann entfernt werden
    override fun toString(): String {
        return "($first $second)"
    }

}
