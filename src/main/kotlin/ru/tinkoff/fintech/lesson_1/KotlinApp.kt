package ru.tinkoff.fintech.lesson_1

import ru.tinkoff.fintech.lesson_1.employees.Director
import ru.tinkoff.fintech.lesson_1.employees.Manager
import ru.tinkoff.fintech.lesson_1.employees.Programmer

fun main() {
    val programmer =
        Programmer("Kotlin developer", "Jhon", 24, 353543, "jlock@tinkoff.ru")

    val manager =
        Manager("Project manager", "Mark", 30, "nlktech", "Megafon.ru")

    val employees =
        listOf(programmer, manager)

    employees.forEach {
        it.work()
        println()
    }

    programmer.teamLeading()
    manager.negotiation()
    val director = Director(manager, programmer)
    director.meeting()
}
