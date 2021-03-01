package com.example.lauraleisu.service

import com.example.lauraleisu.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed = true)
    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        //arrange
        //we dont need this block if we set -> mockk(relaxed =true)
        //every { dataSource.retrieveBanks() } returns emptyList()

        //act
        val banks = bankService.getBanks()

        //assert
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}