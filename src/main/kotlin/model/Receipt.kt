package model

import java.time.LocalDateTime

class Receipt(
    val receiptNo: Int,
    private val entryTime: LocalDateTime,
    private val exitTime: LocalDateTime,
    val fee: Int
) {


    fun getTotalFee(): Int {
        return fee
    }

    fun getParkingDate(): LocalDateTime {
        return entryTime
    }

    fun getUnparkingDate(): LocalDateTime {
        return exitTime
    }


}
