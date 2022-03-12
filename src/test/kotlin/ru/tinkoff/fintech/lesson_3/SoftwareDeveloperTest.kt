package ru.tinkoff.fintech.lesson_3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SoftwareDeveloperTest {

    @Test
    fun `if it works, then working hours are reduced`() {
        //given
        val softwareDeveloper = SoftwareDeveloper("Kotlin developer", "Jhon", 24, 8, 353543, "jlock@tinkoff.ru")

        //when
        softwareDeveloper.work()

        //then
        assertEquals(7, softwareDeveloper.getHours())
    }

    @Test
    fun `if the working day is over, then a new day begins`(){
        //given
        val softwareDeveloper = SoftwareDeveloper("Kotlin developer", "Jhon", 24, 1, 353543, "jlock@tinkoff.ru")

        //when
        softwareDeveloper.work()

        //then
        assertEquals(8, softwareDeveloper.getHours())
    }
}
