package ru.tinkoff.fintech.lesson_3

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

class HeadMaster(
    var projectManager: ProjectManager,
    var softwareDeveloper: SoftwareDeveloper,
    private val name: String = "Rick"
) {
    fun meeting() = println("$name called staff to a meeting $projectManager $softwareDeveloper")
}

class ProjectManager(
    override val position: String,
    override val name: String,
    override val age: Int,
    private var nameProject: String,
    private var nameCustomer: String
) : Employee {

    fun negotiation() = println("Communicates with the client: $nameCustomer of the project: $nameProject")

    override fun work() = println(
        toStringPretty(
            "Management, including the process of planning, " +
                "organizing, motivating and controlling"
        )
    )

    override fun toString(): String {
        return "position ='" + position + '\'' +
            ", name = " + name +
            '}'
    }
}

class SoftwareDeveloper(
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

fun main() {
    val softwareDeveloper = SoftwareDeveloper("Kotlin developer", "Jhon", 24, 353543, "jlock@tinkoff.ru")

    val projectManager = ProjectManager("Project manager", "Mark", 30, "nlktech", "Megafon.ru")

    val employees = listOf(softwareDeveloper, projectManager)

    employees.forEach {
        it.work()
        println()
    }

    softwareDeveloper.teamLeading()
    projectManager.negotiation()
    val headMaster = HeadMaster(projectManager, softwareDeveloper)
    headMaster.meeting()
}
