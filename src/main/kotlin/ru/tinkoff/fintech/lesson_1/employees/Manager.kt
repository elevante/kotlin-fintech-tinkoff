package ru.tinkoff.fintech.lesson_1.employees

class Manager(
    override val position: String, override val name: String,
    override val age: Int, private var nameProject: String, private var nameCustomer: String
) : Employee {

    fun negotiation() =
        println("Communicates with the client: $nameCustomer of the project: $nameProject")

    override fun work() =
        ("Management, including the process of planning, " +
                "organizing, motivating and controlling").prettyPrint()

    override fun toString(): String {
        return "position ='" + position + '\'' +
                ", name = " + name +
                '}'
    }
}
