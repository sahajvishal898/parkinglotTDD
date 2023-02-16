package repo

object TicketRepo {

    private var ticketNumber=0

    fun getTicketNumber(): Int {
        ticketNumber++
        return ticketNumber
    }

    fun exception(): Throwable {
        return TODO("Provide the return value")
    }
}