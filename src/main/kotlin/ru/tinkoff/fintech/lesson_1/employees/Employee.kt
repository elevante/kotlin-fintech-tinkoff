package ru.tinkoff.fintech.lesson_1.employees

interface Employee {
    val position: String
    val name: String
    val age: Int

    fun employeeInfo() = println(toStringPretty("Information about person"))

    fun work()

    fun toStringPretty(text: String): String {
        var textPretty = ""
        textPretty += "position: $position name: $name\n"
        textPretty += text + "\n"
        return textPretty
    }
}
