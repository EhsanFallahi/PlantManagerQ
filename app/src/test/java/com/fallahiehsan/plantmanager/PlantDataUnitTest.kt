package com.fallahiehsan.plantmanager

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fallahiehsan.plantmanager.dto.Plant
import com.fallahiehsan.plantmanager.repository.PlantService
import com.fallahiehsan.plantmanager.ui.main.MainViewModel
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

class PlantDataUnitTest {

    @get:Rule
    var rule:TestRule=InstantTaskExecutorRule()
    var plantService=mockk<PlantService>()

    lateinit var mvm:MainViewModel

    @Test
    fun confirmRose_outputRose(){
        val plant: Plant =Plant("cercis","canadies","rose")
        assertEquals("rose",plant.toString())
    }

    @Test
    fun searchForRedbud_ReturnsRedbud(){
        givenAFeedOfPlantDataAreAvailable()
        whenSearchForRedbud()
        thenResultContainsRedbud()
     }


    private fun givenAFeedOfPlantDataAreAvailable() {
        mvm=MainViewModel()
    }


    private fun whenSearchForRedbud() {
        mvm.fetchPlants("Redbud")
    }

    private fun thenResultContainsRedbud() {
        var redbudFound=false

        mvm.plants.observeForever(){ it ->
            Log.i("plantSize","${it.size}")
            assertNotNull(it)
            assertTrue(it.size>0)
            it.forEach{
                if( it.common.contains("Redbud")){
                    redbudFound=true
                }
            }
        }

                assertTrue(redbudFound)
    }

    @Test
    fun searchForGarbage_returnsNotThing(){
        givenAFeedOfPlantDataAreAvailable()
        whenSearchForGarbage()
        thenIGetZeroResult()
    }

    private fun whenSearchForGarbage() {
        mvm.fetchPlants("adsgorifdglksg")
    }

    private fun thenIGetZeroResult() {
        mvm.plants.observeForever{
            assertEquals(0,it.size)
        }
    }


}