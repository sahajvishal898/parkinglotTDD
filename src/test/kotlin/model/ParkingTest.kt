package model

import org.junit.jupiter.api.Assertions
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

        Assertions.assertEquals(true, isSpotAvailable)
    }


    @Test
    fun `should return the spot number`() {

        val parking = Parking()

        val spotNumber: Int? = parking.getSpotNumber()

        Assertions.assertNotNull(spotNumber)
        Assertions.assertEquals(1, spotNumber)
    }


}