import java.util.Scanner

fun main() {
    // part of task: use break, continue or return
    val scanner = Scanner(System.`in`)
    val word = scanner.next()

    for (char in 'a'..'z') {
        if (char in word) {
            continue
        }
        print(char)
    }
}