package service

import model.Parking
import model.Ticket
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import repo.Repo

class TicketServiceTest {


    @BeforeEach
    fun `clear all before each testcase`() {
        Repo.allTickets.clear()
        Repo.parkingTicketNumber = 0
        Repo.unParkingreceiptNumber = 0
    }

    @Test
    fun `generate the first ticket with ticket number and spot number as 1 `() {

        val parking = Parking()
        val ticket: Ticket = TicketService.generateTicket(parking)

        Assertions.assertEquals(1, ticket.getTicketNo())
        Assertions.assertEquals(1, ticket.getSpotNumber())

    }


    @Test
    fun `should generate the second ticket with ticket number 2 `() {

        val parking = Parking()
        val ticket1: Ticket = TicketService.generateTicket(parking)
        val ticket2: Ticket = TicketService.generateTicket(parking)

        Assertions.assertEquals(1, ticket1.getTicketNo())
        Assertions.assertEquals(2, ticket2.getTicketNo())
    }


}