package service

import model.Parking
import model.Ticket
import repo.TicketRepo
import repo.TicketRepo.exception

object TicketService {
    fun generateTicket(parking: Parking): Ticket {

        val ticketNumber:Int=TicketRepo.getTicketNumber()
        val spotNumber=parking.getAvailableSpotNumber()

        if(spotNumber==null)
            throw exception()

        val ticket=Ticket(ticketNumber,spotNumber)
        return ticket
    }
}