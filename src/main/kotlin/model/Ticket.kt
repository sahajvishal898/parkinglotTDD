package model

import java.time.LocalDateTime


class Ticket(private val ticketNumber:Int, private val spotNumber:Int) {
    private val ticketDate= LocalDateTime.now()
    fun getTicketNo(): Int {
        return ticketNumber
    }

    fun getSpotNumber(): Int {
        return spotNumber
    }

    fun getTicketDate(): LocalDateTime {
        return ticketDate
    }


}