package model

import exceptions.CustomException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import repo.Repo
import java.time.LocalDateTime


class ParkingAreaTest {


    @BeforeEach
    fun `clear all before each testcase`() {
        Repo.allTickets.clear()
        Repo.parkingTicketNumber = 0
        Repo.unParkingreceiptNumber = 0
    }

    @Test
    fun `should return true if parkingArea lot is not filled`() {

        val parkingArea = ParkingArea()

        val isSpotAvailable: Boolean = parkingArea.isSpotAvailable()

        assertEquals(true, isSpotAvailable)
    }


    @Test
    fun `should return the spot number`() {

        val parkingArea = ParkingArea()

        val spotNumber: Int? = parkingArea.getAvailableSpotNumber()

        Assertions.assertNotNull(spotNumber)
        assertEquals(1, spotNumber)
    }


    @Test
    fun `should give true if spot available at given spot number`() {

        val parkingArea = ParkingArea()
        val spotNumber = 2

        val isSpotAvailableAtSpot: Boolean = parkingArea.isSpotAvailableAtSpot(spotNumber)

        assertEquals(true, isSpotAvailableAtSpot)
    }


    @Test
    fun `should park the first car into first parkingArea spot`() {

        val parkingArea = ParkingArea()

        val ticket: Ticket? = parkingArea.parkCarAtParkingArea()

        assertNotNull(ticket)
        assertEquals(1, ticket!!.getSpotNumber())
        assertEquals(false, parkingArea.isSpotAvailableAtSpot(ticket.getSpotNumber()))
    }

    @Test
    fun `should park the second car into second parkingArea spot `() {

        val parkingArea = ParkingArea()

        val ticket1: Ticket? = parkingArea.parkCarAtParkingArea()
        val ticket2: Ticket? = parkingArea.parkCarAtParkingArea()

        assertNotNull(ticket1)
        assertEquals(1, ticket1!!.getSpotNumber())
        assertEquals(false, parkingArea.isSpotAvailableAtSpot(ticket1.getSpotNumber()))

        assertNotNull(ticket1)
        assertEquals(2, ticket2!!.getSpotNumber())
        assertEquals(false, parkingArea.isSpotAvailableAtSpot(ticket2.getSpotNumber()))
    }


    @Test
    fun `should save ticket when car is parked`() {

        val parkingArea = ParkingArea()

        val ticket1: Ticket? = parkingArea.parkCarAtParkingArea()

        assertNotNull(ticket1)
        assertEquals(1, ticket1!!.getSpotNumber())
        assertEquals(false, parkingArea.isSpotAvailableAtSpot(ticket1.getSpotNumber()))
        assertEquals(true, Repo.allTickets.containsKey(ticket1.getTicketNo()))

    }


    @Test
    fun `should generate receipt when car is unparked after 2 hours from spot 1`() {

        val parkingArea = ParkingArea()

        val ticket1: Ticket? = parkingArea.parkCarAtParkingArea()

        assertNotNull(ticket1)
        val receipt: Receipt = parkingArea.unparkCarFromSpot(ticket1!!.getTicketNo(), LocalDateTime.now().plusHours(2))

        assertEquals(20, receipt.fee)
    }


    @Test

    fun `should return the null if all spots are booked`(){
        val parkingArea = ParkingArea()

        for(cnt in 1..100){
            parkingArea.parkCarAtParkingArea()
        }

        val ticket=parkingArea.parkCarAtParkingArea()

        assertNull(ticket)
    }


}