import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Test {
    private val lines = readFile("Day02", true)

    @Test
    fun part1() {
        val day = Day02(lines)

        assertEquals(8, day.part1())
    }

    @Test
    fun part2() {
        val day = Day02(lines)

        assertEquals(2286, day.part2())
    }
}