package com.fallahiehsan.plantmanager.dao

import com.fallahiehsan.plantmanager.dto.Plant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlantDao {

    @GET("/perl/mobile/viewplantsjsonarray.pl")
    fun getAllPlants():Call<ArrayList<Plant>>

    @GET("/perl/mobile/viewplantsjsonarray.pl")
    fun getPlants(
        @Query("Combined_Name")
        plantName:String
    ):Call<ArrayList<Plant>>
}