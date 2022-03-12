package ru.tinkoff.fintech.lesson_3

import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TeamLeaderTest {

    @Test
    fun `when the function trashTalk() is called, the worker writes a letter`() {
        val employee = mockk<SoftwareDeveloper>(relaxUnitFun = true)
        val teamLeader = TeamLeader(employee)

        teamLeader.trashTalk()

        verify(exactly = 1) { employee.writePetition() }
    }

    @Test
    fun `if the worker ends working time while completing the task, a new working day begins`() {
        val employee = spyk(QaEngineer("Lee", 1, "Leen Tee", "Megafon"), recordPrivateCalls = true)
        val teamLeader = TeamLeader(employee)

        teamLeader.giveTask()

        assertEquals(8, employee.getHours())
        verify(exactly = 1) { employee.work() }
        verify(exactly = 1) { employee["nextDay"]() }
    }

    @Test
    fun `if the employee does not end working time when completing the task, a new working day does not begin`() {
        val employee = spyk(QaEngineer("Lee", 8, "Leen Tee", "Megafon"), recordPrivateCalls = true)
        val teamLeader = TeamLeader(employee)

        teamLeader.giveTask()

        assertEquals(7, employee.getHours())
        verify(exactly = 1) { employee.work() }
        verify(exactly = 0) { employee["nextDay"]() }
    }
}
