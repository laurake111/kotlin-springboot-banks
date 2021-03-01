package com.example.lauraleisu.datasource

import com.example.lauraleisu.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank


}