package com.example.lauraleisu.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {


    @Autowired
    lateinit var mockMVC: MockMvc

    @Test
    fun `should return all banks`() {
        //act and assert
        mockMVC.get("/api/banks")
                .andDo { print("hi! Im the get endpoint") }
                .andExpect {
                    status { isOk() } //isOk checks if 200
                    content { contentType(MediaType.APPLICATION_JSON) } //assure that i get a json data type
                    jsonPath("$[0].accountNumber") { value("1234") } //reads the get json string, check 1 bank account
                }

    }

    @Test
    fun `should return the bank with given accountnumber`() {
        val accountNumber = 1234;

        mockMVC.get("/api/banks/$accountNumber")
                .andDo { print() }
                .andExpect { status { isOk() } }
                .andExpect { content { MediaType.APPLICATION_JSON }
                 jsonPath("$.trust") { value("3.14" )}
                 jsonPath("$.transactionFee") { value("17" )}
                }
    }

}