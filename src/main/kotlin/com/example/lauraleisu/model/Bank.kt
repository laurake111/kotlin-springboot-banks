package com.example.lauraleisu.model

// Notes:
// This is a Data Layer (Models, serialization)
// by default, kotlin will set a default getter/setter for you
// if you set a data class you do not need to write hashcode, equals and toString functions

data class Bank(
        val accountNumber: String,
        val trust: Double,
        val transactionFee: Int
)

