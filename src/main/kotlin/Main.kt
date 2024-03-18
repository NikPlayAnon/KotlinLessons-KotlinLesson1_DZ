fun main(args: Array<String>) {
    var line: String = ""
    while (true) {
        var line = readln()
        if (line == "exit") break;
        println(processInput(line))
    }
}

fun processInput(inputLine: String): String? {
    var inputArray = inputLine.split(" ")
    if (inputLine == "help") {
        return (
                """
            • exit
            • help
            • add <Имя> phone <Номер телефона>
            • add <Имя> email <Адрес электронной почты>
        """.trimIndent()
                )
    }
    if (inputArray.count() == 4) {
        if ((inputArray[0] == "add") and (inputArray[2] == "phone")) {
            return if (Regex("^[+][0-9]{8,15}$") in inputArray[3]) {
                "${inputArray[3]} - ${inputArray[1]}"
            } else {
                "phone format error"
            }
        } else if ((inputArray[0] == "add") and (inputArray[2] == "email")) {
            return if (Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$") in inputArray[3]) {
                "${inputArray[3]} - ${inputArray[1]}"
            } else {
                "email format error"
            }
        }
    }
    return "unknown command"
}