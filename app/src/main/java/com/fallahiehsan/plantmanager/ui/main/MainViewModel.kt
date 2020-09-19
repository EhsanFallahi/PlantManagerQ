package com.fallahiehsan.plantmanager.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fallahiehsan.plantmanager.dto.Plant
import com.fallahiehsan.plantmanager.service.PlantService

class MainViewModel : ViewModel() {
    var plants: MutableLiveData<ArrayList<Plant>> = MutableLiveData<ArrayList<Plant>>()

    var plantService=PlantService()

    fun fetchPlants(plantName: String) {
       plants= plantService.fetchPlants(plantName)
    }

}