package ru.tinkoff.fintech.lesson_1.employees

interface Employee {
    val position: String
    val name: String
    val age: Int


    fun employeeInfo() =
        "Information about person".prettyPrint()
    fun work()
    fun String.prettyPrint() {
        println("position: $position name: $name")
        println(this)
        println()
    }
}