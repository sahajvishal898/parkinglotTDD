package service

import model.Parking
import model.Ticket
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ParkingServiceTest {

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

}