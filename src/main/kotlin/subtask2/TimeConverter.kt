package subtask2

class TimeConverter {
    fun toTextFormat(hour: String, minute: String): String {
        return writeTimeInWords(hour.toInt(), minute.toInt())
    }

    private fun writeTimeInWords(h: Int, m: Int): String {
        val words = arrayOf(
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine"
        )
        var time = ""
        if (m == 0) time = "${words[h]} o' clock"
        else if (m in 1..14 || m in 16..29) time = "${words[m]} minutes past ${words[h]}"
        else if (m == 15) time = "quarter past ${words[h]}"
        else if (m == 30) time ="half past ${words[h]}"
        else if (m == 45) time = "quarter to ${words[h+1]}"
        else if (m in 31..44 || m in 46..59) time = "${words[60 - m]} minutes to ${words[(h % 12) + 1]}"
        return time
    }
}
