package service

import model.Parking
import model.Receipt
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime

class ReceiptServiceTest{

    @Test
    fun `should generate a receipt with fee 20 if vehicle parked for 2 hours`(){
        val parking=Parking()

        val ticket=ParkingService.parkCarAtParking(parking)

        val receipt:Receipt= ReceiptService.generateReceipt(ticket, LocalDateTime.now().plusHours(2))

        Assertions.assertEquals(20,receipt.fee)
        Assertions.assertEquals(1,receipt.receiptNo)
    }


}