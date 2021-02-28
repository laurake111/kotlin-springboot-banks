package com.example.lauraleisu.datasource.mock

import com.example.lauraleisu.datasource.BankDataSource
import com.example.lauraleisu.model.Bank
import org.springframework.stereotype.Repository

//responsible for retrieving data and storing
@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf(
            Bank("1234", 3.14,17),
            Bank("1010", 17.0,0),
            Bank("1234222", 0.0,100),
    )

    override fun getBanks(): Collection<Bank> {
        return banks
    }
}