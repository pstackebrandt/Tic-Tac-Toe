fun main() {
    getOriginalText()
            .run { cutMiddle(this) }
            .also { println(it) }
}

fun cutMiddle(text: String) =
        getDropLength(text.length)
                .run { text.take(this) + text.takeLast(this) }

private fun getOriginalText() = readLine()!!
private fun getDropLength(textLength: Int) = (textLength - getMiddlePartLength(textLength)) / 2
private fun getMiddlePartLength(textLength: Int) = if (textLength % 2 == 0) 2 else 1
