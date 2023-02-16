package repo

object TicketRepo {

    var parkingTicketNumber=0

    fun getTicketNumber(): Int {
        parkingTicketNumber++
        return parkingTicketNumber
    }

    fun exception(): Throwable {
        return TODO("Provide the return value")
    }
}