package model

import BOOK
import FREE
import exceptions.CustomException
import LOTSIZE
import repo.Repo
import service.ReceiptService
import service.TicketService
import java.time.LocalDateTime

class ParkingArea {
    private val parkingLot = ArrayList<Int>()

    init {
        for (index in 1..LOTSIZE + 1) parkingLot.add(FREE)
    }

    fun isSpotAvailable(): Boolean {
        for (spot in 1..LOTSIZE) {
            if (parkingLot[spot] == FREE) return true
        }
        return false
    }

    fun getAvailableSpotNumber(): Int? {

        for (spot in 1..LOTSIZE) {
            if (parkingLot[spot] == FREE) return spot
        }
        return null
    }

    fun isSpotAvailableAtSpot(spotNumber: Int): Boolean {
        return parkingLot[spotNumber] == FREE
    }

    private fun bookSpotAt(spotNumber: Int) {
        parkingLot[spotNumber] = BOOK
    }

    private fun unparkVehicleFromSpot(spotNumber: Int) {
        parkingLot[spotNumber] = FREE
    }

    fun parkCarAtParkingArea(): Ticket? {

        val spotNumber = getAvailableSpotNumber() ?: return null

        bookSpotAt(spotNumber)

        return TicketService.generateTicket(spotNumber)

    }

    fun unparkCarFromSpot(ticketNo: Int, dateOfUnparking: LocalDateTime = LocalDateTime.now()): Receipt {

        val ticket = Repo.getTicketWithTicketNo(ticketNo) ?: throw CustomException("No ticketno found")

        unparkVehicleFromSpot(ticket.getSpotNumber())

        return ReceiptService.generateReceipt(ticket, dateOfUnparking)
    }


}