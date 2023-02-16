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


}