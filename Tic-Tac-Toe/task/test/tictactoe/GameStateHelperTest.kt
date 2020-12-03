@file:Suppress("SpellCheckingInspection")

package tictactoe

import org.junit.Assert.assertTrue
import org.junit.Test

class GameStateHelperTest {
    companion object {
        const val CELLS_WITH_ROW_0_TAKEN_BY_X = "XXXO_OOO_"
        const val CELLS_WITH_COLUMN_TAKEN_BY_O = "XO_XO__O_"
        const val CELLS_WITH_SLASH_LINE_TAKEN_BY_O = "X_OXO_O__"
        const val CELLS_WITH_BACK_SLASH_LINE_TAKEN_BY_X = "X_O_XO_OX"
        const val CELLS_WITH_NO_LINE_TAKEN = "XO_______"
        const val CELLS_WITH_REGULAR_CHARACTERS_AND_LENGTH = "XOXO_____"
        const val CELLS_TOO_SHORT = "XOXO__"
        const val CELLS_TOO_LONG = "XOXO_____XO" //11 characters
        const val CELLS_WITH_INVALID_CHARACTERS = "XOXO1#_ _"
        const val CELLS_WITH_PLAYER_CELLS_COUNT_OFF_BALANCE = "XXXO_____"
        const val CELLS_WITH_PLAYER_CELLS_COUNT_OK = "XXOO_____"
        const val CELLS_WITH_UNFINISHED_GAME = "XXOO_____"
        const val CELLS_WITH_STALE_MATE = "XOXXXOOXO"
    }

    @Test
    fun testTest() {
        assertTrue(true)
    }

    class CountPlayerCellsTest {
        @Test
        fun should_deliver_player_cell_counts() {
            val actual = GameStateHelper().countPlayerCells("XXXOO_OO_")
            assert(actual.first > 0) { "Should deliver X cells. delivered: ${actual.first}" }
            assert(actual.second > 0) { "Should deliver O cells. delivered: ${actual.second}" }
        }
    }

    class TakenLinesCountTest {
        @Test
        fun should_detect_that_no_line_taken_by_x() {
            val expected = 0
            val actual = GameStateHelper().takenLinesCount(CELLS_WITH_NO_LINE_TAKEN, Player.X)
            assert(actual == expected) { "Should detect that no row taken. expected: $expected, actual: $actual" }
        }

        @Test
        fun should_detect_row_taken_by_x() {
            val expected = 1
            val actual = GameStateHelper().takenLinesCount(CELLS_WITH_ROW_0_TAKEN_BY_X, Player.X)
            assert(actual == expected) { "Should detect taken row. expected: $expected, actual: $actual" }
        }

        @Test
        fun should_detect_that_column_taken_by_o() {
            val expected = 1
            val actual = GameStateHelper().takenLinesCount(CELLS_WITH_COLUMN_TAKEN_BY_O, Player.O)
            assert(actual == expected) { "Should detect column taken. expected: $expected, actual: $actual" }
        }

        @Test
        fun should_detect_that_slash_line_taken_by_o() {
            val expected = 1
            val actual = GameStateHelper().takenLinesCount(CELLS_WITH_SLASH_LINE_TAKEN_BY_O, Player.O)
            assert(actual == expected) { "Should detect slash line taken. expected: $expected, actual: $actual" }
        }

        @Test
        fun should_detect_that_back_slash_line_taken_by_x() {
            val expected = 1
            val actual = GameStateHelper().takenLinesCount(CELLS_WITH_BACK_SLASH_LINE_TAKEN_BY_X, Player.X)
            assert(actual == expected) { "Should detect back slash line taken. expected: $expected, actual: $actual" }
        }
    }

    class HasValidCharactersTest {
        @Test
        fun should_detect_that_cells_contains_right_characters_only() {
            val expected = true
            val actual = GameStateHelper().hasValidCharacters(CELLS_WITH_REGULAR_CHARACTERS_AND_LENGTH)
            assert(actual == expected) {
                "Should detect that cells contains valid characters only. " +
                        "expected: $expected, actual: $actual"
            }
        }

        @Test
        fun should_detect_that_cells_contains_invalid_characters() {
            val expected = false
            val actual = GameStateHelper().hasValidCharacters(CELLS_WITH_INVALID_CHARACTERS)
            assert(actual == expected) {
                "Should detect that cells contains invalid characters." +
                        " expected: $expected, actual: $actual"
            }
        }
    }

    class HasValidLengthTest {
        @Test
        fun should_detect_that_cells_length_is_ok() {
            val expected = true
            val actual = GameStateHelper().hasValidLength(CELLS_WITH_REGULAR_CHARACTERS_AND_LENGTH)
            assert(actual == expected) {
                "Should detect that cell length is ok. " +
                        "expected: $expected, actual: $actual"
            }
        }

        @Test
        fun should_detect_cells_too_short() {
            val expected = false
            val actual = GameStateHelper().hasValidLength(CELLS_TOO_SHORT)
            assert(actual == expected) {
                "Should detect that cell length is too short. " +
                        "expected: $expected, actual: $actual"
            }
        }

        @Test
        fun should_detect_cells_too_long() {
            val expected = false
            val actual = GameStateHelper().hasValidLength(CELLS_TOO_LONG)
            assert(actual == expected) {
                "Should detect that cell length is too long. " +
                        "expected: $expected, actual: $actual"
            }
        }
    }

    class IsWinnerTest {
        @Test
        fun should_detect_player_is_winner() {
            val expected = true
            val actual = GameStateHelper().isWinner(Player.X, CELLS_WITH_ROW_0_TAKEN_BY_X)
            assert(actual == expected) {
                "Should detect that X is winner. " +
                        "expected: $expected, actual: $actual"
            }
        }

        @Test
        fun should_detect_that_player_is_not_winner() {
            val expected = false
            val actual = GameStateHelper().isWinner(Player.O, CELLS_WITH_ROW_0_TAKEN_BY_X)
            assert(actual == expected) {
                "Should detect that player is not winner. " +
                        "expected: $expected, actual: $actual"
            }
        }
    }

    class CheckGameStateTest {
        @Test
        fun should_detect_stale_mate() {
            val expected = GameState.StaleMate
            val actual = GameStateHelper().checkGameState(CELLS_WITH_STALE_MATE)
            assert(actual == expected) {
                "Should detect stale mate" +
                        "expected: $expected, actual: $actual"
            }
        }

        @Test
        fun should_detect_game_goes_on() {
            val expected = GameState.GameGoesOn
            val actual = GameStateHelper().checkGameState(CELLS_WITH_UNFINISHED_GAME)
            assert(actual == expected) {
                "Should detect game goes on" +
                        "expected: $expected, actual: $actual"
            }
        }
    }

    class IsPlayerCellsCountOkTest {
        @Test
        fun should_detect_player_cells_count_ok() {
            val expected = true
            val actual = GameStateHelper().isPlayerCellsCountOk(CELLS_WITH_PLAYER_CELLS_COUNT_OK)
            assert(actual == expected) {
                "Should detect that player cells count ok" +
                        "expected: $expected, actual: $actual"
            }
        }

        @Test
        fun should_detect_player_cells_count_wrong() {
            val expected = false
            val actual = GameStateHelper().isPlayerCellsCountOk(CELLS_WITH_PLAYER_CELLS_COUNT_OFF_BALANCE)
            assert(actual == expected) {
                "Should detect that player cells count off balance" +
                        " expected: $expected, actual: $actual"
            }
        }
    }
}