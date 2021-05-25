package com.katyrin.popularlibraries.model

class CountersModel {

    private val counters = mutableListOf(0, 0, 0)

    fun next(index: Int) = ++counters[index]

    fun set(index: Int, value: Int) {
        counters[index] = value
    }
}