package com.fallahiehsan.plantmanager

import com.fallahiehsan.plantmanager.dto.Plant
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addTwoAndFour_equalToSix(){
        assertEquals(6,2+4)
    }

    @Test
    fun addThreeAndFour_equalToSix(){
        assertEquals(7,3+4)
    }

    @Test
    fun confirmRose_outputRose(){
        val plant: Plant =Plant("cercis","canadies","rose")
        assertEquals("rose",plant.toString())
    }

    @Test
    fun addThreeAndOne_NotCorrect(){
        assertEquals(2,3+1)
    }

}