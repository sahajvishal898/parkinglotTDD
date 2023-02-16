package repo

import model.Ticket

object TicketRepo {

    var parkingTicketNumber=0

    val allTickets= mutableMapOf<Int,Ticket>()

    fun getTicketNumber(): Int {
        parkingTicketNumber++
        return parkingTicketNumber
    }


    fun addTicketToRepo(ticket: Ticket){
        allTickets.put(ticket.getTicketNo(),ticket)
    }



    fun exception(): Throwable {
        return TODO("Provide the return value")
    }
}