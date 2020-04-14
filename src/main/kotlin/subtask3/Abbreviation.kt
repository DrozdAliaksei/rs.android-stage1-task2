package subtask3

class Abbreviation {
    fun abbreviationFromA(a: String, b: String): String {
        var upper = b.length
        b.forEachIndexed { b1, charB ->
            a.toUpperCase().forEachIndexed { a1, charA -> if (a1 > b1 && charB == charA) upper-- }
        }

        return if (upper == 0) "YES"
        else "NO"
    }
}
