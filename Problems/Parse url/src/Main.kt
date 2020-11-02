const val EQUAL_DELIMITER = '='

fun main() {
    val url = readLine()!!
    val query = url.substringAfter("?").split('&')

    query.filter { it.contains(EQUAL_DELIMITER) }
            .apply {
                map {
                    getQueryContentFormatted(it)
                }
                        .forEach { formattedQueryEntry -> println(formattedQueryEntry) }
            }
            .firstOrNull {
                it.substringBefore(EQUAL_DELIMITER) == "pass"
            }
            ?.apply {
                println(getPasswordFormatted(this))
            }
}

private fun getPasswordFormatted(passwordQueryEntry: String) = "password : ${passwordQueryEntry.substringAfter(EQUAL_DELIMITER)}"

private fun getQueryContentFormatted(it: String) =
        "${it.substringBefore(EQUAL_DELIMITER)} : ${
            it.substringAfter(EQUAL_DELIMITER).run {
                if (this.isNotEmpty()) {
                    this
                } else {
                    "not found"
                }
            }
        }"