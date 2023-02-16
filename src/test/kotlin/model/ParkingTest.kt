package model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ParkingTest {


    @BeforeEach
    fun `clear all before each testcase`() {

    }

    @Test
    fun `should return true if parking lot is not filled`() {

        val parking = Parking()

        val isSpotAvailable: Boolean = parking.isSpotAvailable()

        assertEquals(true, isSpotAvailable)
    }


    @Test
    fun `should return the spot number`() {

        val parking = Parking()

        val spotNumber: Int? = parking.getSpotNumber()

        Assertions.assertNotNull(spotNumber)
        assertEquals(1, spotNumber)
    }


    @Test
    fun `should give true if spot available at given spot number`() {

        val parking = Parking()
        val spotNumber = 2

        val isSpotAvailableAtSpot: Boolean = parking.isSpotAvailableAtSpot(spotNumber)

        assertEquals(true, isSpotAvailableAtSpot)
    }

    @Test
    fun `should book spot at given spot number`() {

        val parking = Parking()
        val spotNumber = 2

        val isBookingSpotSuccessful: Boolean = parking.bookSpotAt(spotNumber)

        assertEquals(true, isBookingSpotSuccessful)
    }


}