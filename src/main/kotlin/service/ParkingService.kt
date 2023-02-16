package service

import model.Parking
import model.Ticket
import repo.TicketRepo.exception

object ParkingService {
    fun parkCarAtParking(parking: Parking): Ticket {


        val ticket=TicketService.generateTicket(parking)

        val isCarParked=parking.bookSpotAt(ticket.getSpotNumber())

        if(!isCarParked)
            throw exception()

        return ticket
    }




}