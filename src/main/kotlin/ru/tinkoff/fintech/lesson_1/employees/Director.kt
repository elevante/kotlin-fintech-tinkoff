package ru.tinkoff.fintech.lesson_1.employees

class Director(var manager: Manager, var programmer: Programmer, private val name: String = "Rick") {
    fun meeting() {
        println("$name called staff to a meeting $manager $programmer")
    }
}