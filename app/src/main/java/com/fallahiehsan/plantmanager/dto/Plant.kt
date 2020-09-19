package com.fallahiehsan.plantmanager.dto

import com.google.gson.annotations.SerializedName

class Plant(
    var genus:String,
    var species:String,
    var common:String,
    @SerializedName("id")
    var plantId:Int=0
) {
    override fun toString(): String {
        return common
    }
}