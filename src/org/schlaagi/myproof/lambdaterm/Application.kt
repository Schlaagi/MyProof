package org.schlaagi.myproof.lambdaterm

//ToDo: gescheite Namen für die Parameter
class Application(val first: LambdaTerm, val second: LambdaTerm) : LambdaTerm {
    override fun getFreeVariables(): Set<Variable> {
        return first.getFreeVariables().union(second.getFreeVariables())
    }

}
