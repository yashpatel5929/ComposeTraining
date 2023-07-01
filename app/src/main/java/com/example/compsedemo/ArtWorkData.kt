package com.example.compsedemo

data class ArtWorkData(
    val image : Int,
    val imageDescription : String ?= "",
    val imageCreator : String ?= "",
)
