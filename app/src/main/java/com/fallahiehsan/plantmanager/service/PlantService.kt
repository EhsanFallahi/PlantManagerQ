package com.fallahiehsan.plantmanager.service

import androidx.lifecycle.MutableLiveData
import com.fallahiehsan.plantmanager.dto.Plant

class PlantService {

    fun fetchPlants(plantName:String):MutableLiveData<ArrayList<Plant>>{
        return MutableLiveData<ArrayList<Plant>>()
    }

}