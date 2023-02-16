package service

import exceptions.CustomException
import model.Parking
import model.Receipt
import model.Ticket
import repo.Repo
import java.time.LocalDateTime

object ParkingService {
    fun parkCarAtParking(parking: Parking): Ticket {


        val ticket=TicketService.generateTicket(parking)
        Repo.addTicketToRepo(ticket)

        val isCarParked=parking.bookSpotAt(ticket.getSpotNumber())

        if(!isCarParked)
            throw CustomException("If car not parked")

        return ticket
    }



    fun unparkCarFromSpot(parking: Parking, ticketNo: Int,dateOfUnparking: LocalDateTime = LocalDateTime.now()): Receipt {

        val ticket = Repo.getTicketWithTicketNo(ticketNo) ?: throw CustomException("No ticketno found")

        parking.unparkVehicleFromSpot(ticketNo)

        return ReceiptService.generateReceipt(ticket,dateOfUnparking)
    }



}