package com.fallahiehsan.plantmanager.dto

class Plant(
    var genus:String,
    var species:String,
    var common:String
) {
    override fun toString(): String {
        return common
    }
}