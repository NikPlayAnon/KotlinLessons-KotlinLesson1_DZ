fun main(args: Array<String>) {
    var line: String = ""
    while (true) {
        var line = readln()
        processInput(line)
        if (line=="exit") break;
    }
}

fun processInput(inputLine: String) {
    var inputArray = inputLine.split(" ")
    if (inputLine == "help") {
        println(
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
            if (Regex("^[+][0-9]{8,15}$") in inputArray[3]){
                println("${inputArray[3]} - ${inputArray[1]}")
            } else {
                println("phone format error")
            }
        } else if ((inputArray[0] == "add") and (inputArray[2] == "email")){
            if (Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\$") in inputArray[3]){
                println("${inputArray[3]} - ${inputArray[1]}")
            } else {
                println("email format error")
            }
        }
    }
}