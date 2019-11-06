package org.schlaagi.myproof.minimal_logic

data class Implication(val antecedent: Formula, val consequent: Formula) : Formula {
    override fun toString(): String {
        val antecedentString = if (antecedent is Implication) "[$antecedent]" else "$antecedent"
        return "$antecedentString => $consequent"
    }
}
