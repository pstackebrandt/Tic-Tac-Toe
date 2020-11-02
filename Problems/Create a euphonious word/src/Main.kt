fun main() {
    getWord().run { getLengthsOfLetterGroups(this) }
            .run { additionalLettersForEuphoniousWord(this) }
            .apply { println(this) }
}

private fun getWord() = readLine()!!

fun getLengthsOfLetterGroups(text: String): List<Int> {
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')
    var groupIsVowels = true
    var groupLength = 0
    val groupLengths = mutableListOf<Int>()

    text.toLowerCase().forEachIndexed { index, letter ->
        val currentIsVowel = letter in vowels

        fun initGroupInFirstLoop() {
            if (index == 0) {
                groupIsVowels = !currentIsVowel
            }
        }

        fun initNewGroup() {
            groupLength = 1
            groupIsVowels = currentIsVowel
        }

        fun isLetterInSameGroup() = currentIsVowel == groupIsVowels

        fun saveGroup() {
            if (index > 0) {
                groupLengths.add(groupLength)
            }
        }

        fun saveGroupInLastLoop() {
            if (index == text.lastIndex) {
                saveGroup()
            }
        }

        initGroupInFirstLoop()

        if (isLetterInSameGroup()) {
            groupLength++
        } else {
            saveGroup()
            initNewGroup()
        }
        saveGroupInLastLoop()
    }

    return groupLengths
}

fun additionalLettersForEuphoniousWord(lengthsOfLetterGroups: List<Int>) =
        lengthsOfLetterGroups.map { groupLength ->
            if (groupLength < 2) {
                0
            } else {
                (groupLength + 1) / 2 - 1
            }
        }.sum()
