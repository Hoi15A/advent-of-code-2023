fun main() {
    val lines = readFile("Day01", false)
    val day = Day01(lines)

    day.run()
}

class Day01(private val lines: List<String>) : Day {

    override fun part1(): Any {
        return processLines(lines)
    }

    override fun part2(): Any {
        return processLines(lines.map { mapTextNumsToInt(it) })
    }

    private fun processLines(lines: List<String>): Int {
        return lines
            .map { it.replace(Regex("\\D"), "") }
            .map { "${it.first()}${it.last()}" }
            .mapTo(mutableListOf()) { it.toInt() }
            .sum()
    }

    private val numberMap = mapOf(
        Pair("one", "o1e"),
        Pair("two", "t2o"),
        Pair("three", "t3e"),
        Pair("four", "f4r"),
        Pair("five", "f5e"),
        Pair("six", "s6x"),
        Pair("seven", "s7n"),
        Pair("eight", "e8t"),
        Pair("nine", "n9e"),
    )
    private val numberRegex = Regex("(one|two|three|four|five|six|seven|eight|nine)")

    private fun mapTextNumsToInt(line: String): String {
        var updatedLine = line

        while(true) {
            val match = numberRegex.find(updatedLine)?.value
            if (match != null) {
                val nextNum = numberMap[match]
                updatedLine = updatedLine.replaceFirst(match, nextNum!!)
            } else {
                break
            }
        }

        return updatedLine
    }

}