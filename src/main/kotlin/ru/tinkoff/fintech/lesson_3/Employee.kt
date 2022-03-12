package ru.tinkoff.fintech.lesson_3

abstract class Employee(
    val name: String,
    var workHours: Int,
) {

    abstract fun work()

    abstract fun writePetition()

    protected fun nextDay() {
        workHours = 8
    }

    fun getHours() = workHours


    private fun toStringPretty(text: String): String {
        var textPretty = ""
        textPretty += "name: $name\n"
        textPretty += text + "\n"
        return textPretty
    }
}


class TeamLeader(private val employee: Employee) {
    fun giveTask() = employee.work()
    fun trashTalk() = employee.writePetition()
}

class QaEngineer(
    name: String,
    workHours: Int,
    private var businessAnalyst: String,
    private var nameCustomer: String
) : Employee(name, workHours) {

    override fun writePetition() {
        workHours -= 2
        println("$name is writing a petition")
    }

    override fun work() {
        workHours -= 1
        println("$name is testing")
        if (workHours == 0) nextDay()
    }


    fun negotiation() = println("Communicates with the client: $nameCustomer"
        + " and business analyst: $businessAnalyst and testing program\n")

}

class SoftwareDeveloper(
    name: String,
    workHours: Int,
) : Employee(name, workHours) {

    fun performs(topic: String) = println("Programmer $name speaks on the topic:$topic")

    fun performs(topic: String, conferenceName: String) = println("Programmer $name speaks on "
        + "the topic:$topic at $conferenceName conference")

    fun designs() {
        println("Designs architecture")
    }

    override fun writePetition() {
        workHours -= 2
        println("$name is writing a petition\n")
    }

    override fun work() {
        workHours -= 1
        println("$name is coding")
        if (workHours == 0) nextDay()
    }
}

fun main() {
    /***1***/
    val softwareDeveloper = SoftwareDeveloper("Mark", 8)
    val qaEngineer = QaEngineer("Lee", 8,  "Leen Tee", "Megafon")
    val employees = listOf(softwareDeveloper, qaEngineer)
    employees.forEach {
        it.work()
        println()
    }
    softwareDeveloper.designs()
    qaEngineer.negotiation()

    /***2***/
    val frontedLeader = TeamLeader(qaEngineer)
    val backendLeader = TeamLeader(softwareDeveloper)
    frontedLeader.giveTask()
    backendLeader.trashTalk()
}
