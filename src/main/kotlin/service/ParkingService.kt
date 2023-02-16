package service

import exceptions.CustomException
import model.Parking
import model.Ticket
import repo.Repo

object ParkingService {
    fun parkCarAtParking(parking: Parking): Ticket {


        val ticket=TicketService.generateTicket(parking)
        Repo.addTicketToRepo(ticket)

        val isCarParked=parking.bookSpotAt(ticket.getSpotNumber())

        if(!isCarParked)
            throw CustomException("If car not parked")

        return ticket
    }


}