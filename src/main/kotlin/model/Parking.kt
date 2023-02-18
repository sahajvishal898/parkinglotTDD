package model

import exceptions.CustomException
import lotSize
import repo.Repo
import service.ReceiptService
import service.TicketService
import java.time.LocalDateTime

class Parking {
    private val parkingLot = ArrayList<Int>()

    init {
        for (index in 1..lotSize + 1)
            parkingLot.add(1)
    }

    fun isSpotAvailable(): Boolean {
        for (spot in 1..lotSize) {
            if (parkingLot[spot] == 1)
                return true
        }
        return false
    }

    fun getAvailableSpotNumber(): Int? {

        for (spot in 1..lotSize) {
            if (parkingLot[spot] == 1)
                return spot
        }
        return null
    }

    fun isSpotAvailableAtSpot(spotNumber: Int): Boolean {
        return parkingLot[spotNumber] == 1
    }

    fun bookSpotAt(spotNumber: Int): Boolean {

        if (!isSpotAvailableAtSpot(spotNumber))
            return false
        parkingLot[spotNumber] = 0
        return true
    }

    fun unparkVehicleFromSpot(spotNumber: Int) {
        parkingLot[spotNumber] = 1
    }

    fun parkCarAtParking(): Ticket {

        val ticket = TicketService.generateTicket(this)
        Repo.addTicketToRepo(ticket)

        val isCarParked = bookSpotAt(ticket.getSpotNumber())

        if (!isCarParked)
            throw CustomException("If car not parked")

        return ticket

    }

    fun unparkCarFromSpot(ticketNo: Int,dateOfUnparking: LocalDateTime = LocalDateTime.now()): Receipt {

        val ticket = Repo.getTicketWithTicketNo(ticketNo) ?: throw CustomException("No ticketno found")

        unparkVehicleFromSpot(ticketNo)

        return ReceiptService.generateReceipt(ticket, dateOfUnparking)
    }


}