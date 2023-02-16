package service

import model.Receipt
import model.Ticket
import repo.Repo
import java.time.Duration
import java.time.LocalDateTime

const val FEES_PER_HOUR=10
class ReceiptService {
    companion object {
        fun generateReceipt(ticket: Ticket, dateOfUnparking: LocalDateTime): Receipt {

            val durationInHours = Duration.between(ticket.getTicketDate(),dateOfUnparking).toHours().toInt()
            val fee = durationInHours* FEES_PER_HOUR

            return Receipt(Repo.getReceiptNumber(), ticket.getTicketDate(), dateOfUnparking, fee)
        }
    }
}