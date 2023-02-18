package service

import model.Ticket
import repo.Repo

object TicketService {
    fun generateTicket(spotNumber: Int): Ticket {

        val ticketNumber: Int = Repo.getTicketNumber()

        val ticket = Ticket(ticketNumber, spotNumber)
        Repo.addTicketToRepo(ticket)

        return ticket
    }
}