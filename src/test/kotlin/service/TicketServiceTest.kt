package service

import model.Parking
import model.Ticket
import org.junit.Assert.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TicketServiceTest{

    @Test
    fun `generate the first ticket with ticket number and spot number as 1 `(){

        val parking = Parking()
        val ticket: Ticket =TicketService.generateTicket(parking)


        Assertions.assertEquals(1,ticket.getTicketNo())
        Assertions.assertEquals(1,ticket.getSpotNumber())

    }


}