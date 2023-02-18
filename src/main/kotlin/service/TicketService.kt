package service

import exceptions.CustomException
import model.Parking
import model.Ticket
import repo.Repo

object TicketService {
    fun generateTicket(parking: Parking): Ticket {

        val ticketNumber: Int = Repo.getTicketNumber()
        val spotNumber = parking.getAvailableSpotNumber() ?: throw CustomException("No spot available")

        val ticket = Ticket(ticketNumber, spotNumber)
        return ticket
    }
}