fun main() {
    val lines = readFile("Day02", false)
    val day = Day02(lines)

    day.run()
}

class Day02(private val lines: List<String>) : Day {

    private data class CubeSet(val red: Int, val green: Int, val blue: Int)
    private data class Game(val id: Int, val pulls: MutableList<CubeSet>)

    override fun part1(): Any {
        val games = parseGames()
        val possibleGames = mutableListOf<Game>()
        val impossibleGames = mutableListOf<Game>()
        for (game in games) {
            var gamePossible = true
            for (pull in game.pulls) {
                if (pull.red > 12 || pull.green > 13 || pull.blue > 14) {
                    gamePossible = false
                    break
                }
            }
            if (gamePossible) possibleGames.add(game) else impossibleGames.add(game)
        }

        return possibleGames.sumOf { it.id }
    }

    override fun part2(): Any {
        val games = parseGames()
        var totalPower = 0
        for (game in games) {
            val maxRed = game.pulls.maxOf { it.red }
            val maxGreen = game.pulls.maxOf { it.green }
            val maxBlue = game.pulls.maxOf { it.blue }
            val power = maxRed * maxGreen * maxBlue
            totalPower += power
        }
        return totalPower
    }

    private fun parseGames(): List<Game> {
        val list = mutableListOf<Game>()

        for (line in lines) {
            val colonSplit = line.split(":")
            val gameId = colonSplit[0].split(" ")[1]
            val game = Game(gameId.toInt(), mutableListOf())
            val cubeStr = colonSplit[1]

            for (cubeSet in cubeStr.split(";")) {
                var red = 0
                var green = 0
                var blue = 0
                for (cube in cubeSet.split(",")) {
                    val cs = cube.trim().split(" ")
                    val count = cs[0].toInt()
                    val colour = cs[1]
                    when (colour) {
                        "red" -> red = count
                        "green" -> green = count
                        "blue" -> blue = count
                    }
                }
                game.pulls.add(CubeSet(red, green, blue))
            }

            list.add(game)
        }

        return list
    }

}