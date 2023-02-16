package service

import model.Parking
import model.Receipt
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import repo.Repo
import java.time.LocalDateTime

class ReceiptServiceTest{


    @BeforeEach
    fun `clear all before each testcase`() {
        Repo.allTickets.clear()
        Repo.parkingTicketNumber=0
        Repo.unParkingreceiptNumber=0
    }
    @Test
    fun `should generate a receipt with fee 20 if vehicle parked for 2 hours`(){
        val parking=Parking()

        val ticket=ParkingService.parkCarAtParking(parking)

        val receipt:Receipt= ReceiptService.generateReceipt(ticket, LocalDateTime.now().plusHours(2))

        Assertions.assertEquals(20,receipt.fee)
        Assertions.assertEquals(1,receipt.receiptNo)
    }


}