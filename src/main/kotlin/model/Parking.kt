package model

import lotSize

class Parking {
    private val parkingLot=ArrayList<Int>()

    init {
        for(index in 1..lotSize)
            parkingLot.add(1)
    }

    fun isSpotAvailable(): Boolean {
        for(spot in 1..lotSize) {
            if(parkingLot[spot]==1)
                return true
        }
        return false
    }



}