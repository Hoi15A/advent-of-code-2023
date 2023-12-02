import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
    private val linesPart1 = readFile("Day01p1", true)
    private val linesPart2 = readFile("Day01p2", true)

    @Test
    fun part1() {
        val day = Day01(linesPart1)

        assertEquals(142, day.part1())
    }

    @Test
    fun part2() {
        val day = Day01(linesPart2)

        assertEquals(281, day.part2())
    }
}