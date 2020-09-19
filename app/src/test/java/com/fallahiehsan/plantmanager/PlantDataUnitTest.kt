package com.fallahiehsan.plantmanager

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.fallahiehsan.plantmanager.dto.Plant
import com.fallahiehsan.plantmanager.service.PlantService
import com.fallahiehsan.plantmanager.ui.main.MainViewModel
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.AdditionalMatchers.not
import org.mockito.AdditionalMatchers.or

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
        givenAFeedOfMockedPlantDataAreAvailable()
        whenSearchForRedbud()
        thenResultContainsRedbud()
        thebVerifyFunctionsInvoked()
    }

    private fun thebVerifyFunctionsInvoked() {
        verify { plantService.fetchPlants("Redbud") }
        confirmVerified(plantService)
    }

    private fun givenAFeedOfMockedPlantDataAreAvailable() {
        mvm=MainViewModel()
        createMockData()
    }

    private fun createMockData() {
        var allPlantService=MutableLiveData<ArrayList<Plant>>()
        var allPlants=ArrayList<Plant>()

        var redbud=Plant("Cercis","canadecsis","Eastern Redbud")
        allPlants.add(redbud)

        var redOak=Plant("Quercus","rubra","Red Oak")
        allPlants.add(redOak)

        var whiteOak=Plant("Quercus","alba","White Oak")
        allPlants.add(whiteOak)

        allPlantService.postValue(allPlants)
        every{plantService.fetchPlants(or("Redbud","Quercus"))} returns allPlantService
        every{plantService.fetchPlants(not(or("Redbud","Quercus")))} returns MutableLiveData<ArrayList<Plant>>()
        mvm.plantService=plantService
    }

    private fun whenSearchForRedbud() {
        mvm.fetchPlants("Redbud")
    }

    private fun thenResultContainsRedbud() {
        var redbudFound=false

        mvm.plants.observeForever(){
            assertNotNull(it)
            assertTrue(it.size>0)
            it.forEach{
                if(it.genus=="Cercis" && it.species=="canadecsis" && it.common.contains("Eastern Redbud")){
                    redbudFound=true
                }
            }
        }

        assertTrue(redbudFound)
    }

    @Test
    fun searchForGarbage_returnsNotThing(){
        givenAFeedOfMockedPlantDataAreAvailable()
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