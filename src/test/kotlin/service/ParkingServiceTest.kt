package service

import model.Parking
import model.Receipt
import model.Ticket
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import repo.Repo
import java.time.LocalDateTime

class ParkingServiceTest {

    @BeforeEach
    fun `clear all before each testcase`() {
        Repo.allTickets.clear()
        Repo.parkingTicketNumber=0
        Repo.unParkingreceiptNumber=0
    }
    @Test
    fun `should park the first car into first parking spot parking`() {

        val parking = Parking()

        val ticket: Ticket = ParkingService.parkCarAtParking(parking)

        Assertions.assertEquals(1, ticket.getSpotNumber())
        Assertions.assertEquals(false, parking.isSpotAvailableAtSpot(ticket.getSpotNumber()))
    }

    @Test
    fun `should park the second car into second parking spot parking`() {

        val parking = Parking()

        val ticket1: Ticket = ParkingService.parkCarAtParking(parking)
        val ticket2: Ticket = ParkingService.parkCarAtParking(parking)

        Assertions.assertEquals(1, ticket1.getSpotNumber())
        Assertions.assertEquals(false, parking.isSpotAvailableAtSpot(ticket1.getSpotNumber()))

        Assertions.assertEquals(2, ticket2.getSpotNumber())
        Assertions.assertEquals(false, parking.isSpotAvailableAtSpot(ticket2.getSpotNumber()))
    }


    @Test
    fun `should save ticket when car is parked`() {

        val parking = Parking()

        val ticket1: Ticket = ParkingService.parkCarAtParking(parking)

        Assertions.assertEquals(1, ticket1.getSpotNumber())
        Assertions.assertEquals(false, parking.isSpotAvailableAtSpot(ticket1.getSpotNumber()))
        Assertions.assertEquals(true,Repo.allTickets.containsKey(ticket1.getTicketNo()))

    }


    @Test
    fun `should generate receipt when car is unparked after 2 hours from spot 1`() {

        val parking = Parking()

        val ticket1: Ticket = ParkingService.parkCarAtParking(parking)

        val receipt : Receipt = ParkingService.unparkCarFromSpot(parking,ticket1.getTicketNo(), LocalDateTime.now().plusHours(2))

        Assertions.assertEquals(20,receipt.fee)



    }









}