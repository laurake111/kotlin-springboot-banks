package com.example.lauraleisu.datasource

import com.example.lauraleisu.model.Bank

interface BankDataSource {

    fun getBanks(): Collection<Bank>

}