fun main() {
    val word = readLine()!!

    // part of task: use break/continue/return
    var countOf1Appearance = 0
    for(letter in 'a'..'z'){
        if(word.filter { it == letter }.count() != 1) {
            continue
        }
        countOf1Appearance++
    }
    println(countOf1Appearance)
}