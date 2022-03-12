package ru.tinkoff.fintech.lesson_3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SoftwareDeveloperTest {

    @Test
    fun `if it works, then working hours are reduced`() {
        //given
        val softwareDeveloper = SoftwareDeveloper("Mark", 8, 2311313)

        //when
        softwareDeveloper.work()

        //then
        assertEquals(7, softwareDeveloper.getHours())
    }

    @Test
    fun `if the working day is over, then a new day begins`() {
        //given
        val softwareDeveloper = SoftwareDeveloper("Mark", 8, 2311313)

        //when
        softwareDeveloper.work()

        //then
        assertEquals(8, softwareDeveloper.getHours())
    }
}
