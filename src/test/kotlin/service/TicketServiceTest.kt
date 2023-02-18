package service

import model.ParkingArea
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

        val parkingArea = ParkingArea()
        val spotNumber=parkingArea.getAvailableSpotNumber()!!

        val ticket: Ticket = TicketService.generateTicket(spotNumber)

        Assertions.assertEquals(1, ticket.getTicketNo())
        Assertions.assertEquals(1, ticket.getSpotNumber())

    }


    @Test
    fun `should generate the second ticket with ticket number 2 `() {

        val parkingArea = ParkingArea()
        val ticket1: Ticket = TicketService.generateTicket(1)
        val ticket2: Ticket = TicketService.generateTicket(2)

        Assertions.assertEquals(1, ticket1.getTicketNo())
        Assertions.assertEquals(2, ticket2.getTicketNo())
    }


}