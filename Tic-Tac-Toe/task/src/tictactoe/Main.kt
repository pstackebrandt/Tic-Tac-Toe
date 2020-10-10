package tictactoe

import java.util.Scanner

fun main() {
    val cells = getInput()
    printGame(cells)
}

fun getInput(): String {
    val scanner = Scanner(System.`in`)
    return scanner.next()
}

fun printGame(cells: String) {
    println("---------")
    println("| ${cells[0]} ${cells[1]} ${cells[2]} |")
    println("| ${cells[3]} ${cells[4]} ${cells[5]} |")
    println("| ${cells[6]} ${cells[7]} ${cells[8]} |")
    println("---------")
}
