package model

import java.time.LocalDateTime

class Ticket(private val ticketNumber:Int, private val spotNumber:Int) {
    fun getTicketNo(): Int {
        return ticketNumber
    }

    fun getSpotNumber(): Int {
        return spotNumber
    }

    var date: LocalDateTime = LocalDateTime.now()




}