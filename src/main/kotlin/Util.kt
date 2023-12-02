import java.io.File

fun readFile(name: String, test: Boolean = false) =
    File("src/${if (test) "test" else "main"}/resources/$name.txt").readLines()
