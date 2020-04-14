package subtask4

class Pangram {
    private val alphabet = 'a'..'z'
    private val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    private val consonants = alphabet.filterNot { vowels.contains(it) }

    fun getResult(inputString: String): String {
        val strings = inputString.replace("/n", " ").split(" ")
            .filter { it.isNotBlank() } as MutableList
        if (inputString.isBlank()) return ""
        if (isPangram(inputString)) {
            strings.forEachIndexed { word, string ->
                var countVowels = 0
                var newWord = ""
                string.forEach { x ->
                    when {
                        x in vowels -> {
                            newWord += x.toUpperCase()
                            countVowels++
                        }
                        x.toLowerCase() in vowels -> {
                            newWord += x
                            countVowels++
                        }
                        else -> newWord += x
                    }
                }
                strings[word] = "$countVowels$newWord"
            }
            strings.sortWith(compareBy { it[0] })
        } else {
            strings.forEachIndexed { word, string ->
                var countConsonants = 0
                var newWord = ""
                string.forEach { x ->
                    when {
                        x in consonants -> {
                            newWord += x.toUpperCase()
                            countConsonants++
                        }
                        x.toLowerCase() in consonants -> {
                            newWord += x
                            countConsonants++
                        }
                        else -> newWord += x
                    }
                }
                strings[word] = "$countConsonants$newWord"
            }
            strings.sortBy { it[0] }
        }
        return strings.joinToString(" ")
    }
}

private fun isPangram(text: String): Boolean {
    var alphabet = 0
    for (char in 'Z' downTo 'A') {
        var found = false
        text.forEach { t -> if (t.toUpperCase() == char) found = true }
        if (found) alphabet++
    }
    return alphabet == 26
}
