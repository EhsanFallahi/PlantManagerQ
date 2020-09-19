package com.fallahiehsan.plantmanager.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fallahiehsan.plantmanager.RetrofitClientInstance
import com.fallahiehsan.plantmanager.dao.IPlantDao
import com.fallahiehsan.plantmanager.dto.Plant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantService {

    fun fetchPlants(plantName:String):MutableLiveData<ArrayList<Plant>>{
        Log.i("plantResponse"," PlantService")
        var _plants=MutableLiveData<ArrayList<Plant>>()
        val service=RetrofitClientInstance.retrofitInstance?.create(IPlantDao::class.java)
        val call=service?.getAllPlants()
        call?.enqueue(object:Callback<ArrayList<Plant>>{
            override fun onResponse(
                call: Call<ArrayList<Plant>>,
                response: Response<ArrayList<Plant>>
            ) {
                _plants.value=response.body()
                Log.i("plantResponse","res:${response.body()}")
            }

            override fun onFailure(call: Call<ArrayList<Plant>>, t: Throwable) {
                val j=1+1
                val i=1+1
                Log.i("plantResponse","Failure${t.message}")
            }

        })

        return _plants
    }

}