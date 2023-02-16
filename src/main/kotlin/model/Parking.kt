package model

import lotSize

class Parking {
    private val parkingLot = ArrayList<Int>()

    init {
        for (index in 1..lotSize + 1)
            parkingLot.add(1)
    }

    fun isSpotAvailable(): Boolean {
        for (spot in 1..lotSize) {
            if (parkingLot[spot] == 1)
                return true
        }
        return false
    }

    fun getAvailableSpotNumber(): Int? {

        for (spot in 1..lotSize) {
            if (parkingLot[spot] == 1)
                return spot
        }
        return null
    }

    fun isSpotAvailableAtSpot(spotNumber: Int): Boolean {
        return parkingLot[spotNumber] == 1
    }

    fun bookSpotAt(spotNumber: Int): Boolean {

        if (!isSpotAvailableAtSpot(spotNumber))
            return false
        parkingLot[spotNumber] = 0
        return true
    }


}