package repo

import model.Ticket

object Repo {

    var parkingTicketNumber=0
    var unParkingreceiptNumber=0
    val allTickets= mutableMapOf<Int,Ticket>()

    fun getTicketNumber(): Int {
        parkingTicketNumber++
        return parkingTicketNumber
    }
    fun getReceiptNumber(): Int {
        unParkingreceiptNumber++
        return unParkingreceiptNumber
    }

    fun getTicketWithTicketNo(ticketNo:Int): Ticket? {

        if(!allTickets.containsKey(ticketNo))
            return null

        return allTickets.getValue(ticketNo)
    }

    fun addTicketToRepo(ticket: Ticket){
        allTickets.put(ticket.getTicketNo(),ticket)
    }

}