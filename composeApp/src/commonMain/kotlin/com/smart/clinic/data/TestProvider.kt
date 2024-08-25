package com.smart.clinic.data

interface TestProvider {
    fun myPrint():String
}

class TestProvideImpl(
    val dcClient: DbClient,
):TestProvider{

    override fun myPrint():String {
        return "Sajjad King"
    }
}