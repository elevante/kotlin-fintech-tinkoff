package ru.tinkoff.fintech.lesson_1.employees

class Programmer(
    override val position: String,
    override val name: String,
    override val age: Int,
    private var workIdInfo: Int,
    private var email: String
) : Employee {
    fun performs(topic: String) = println("Programmer $name speaks on the topic:$topic")

    fun performs(topic: String, conferenceName: String) = println(
        "Programmer $name speaks on the " +
            "topic:$topic at $conferenceName conference"
    )

    fun getWorkIdInfo() = workIdInfo

    fun getEmail() = email

    fun teamLeading() = println("Manages the team")

    override fun work() = println(toStringPretty("Сoding a million dollar program"))

    override fun toString(): String {
        return "position ='" + position + '\'' +
            ", name = " + name +
            '}'
    }
}
