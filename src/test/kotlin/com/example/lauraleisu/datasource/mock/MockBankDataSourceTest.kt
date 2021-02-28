package com.example.lauraleisu.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Sets
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

    private val mockDataSource: MockBankDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        //arrange

        //act
        val banks = mockDataSource.retrieveBanks()

        //assert
        assertThat(banks).isNotEmpty
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide unique accountnumber`() {
        //arrange

        //act
        val banks = mockDataSource.retrieveBanks()
        val tempBanks: MutableSet<String> = Sets.newHashSet()
        var unique = true;

        //assert
        for (bank in banks) {
            if (tempBanks.contains(bank.accountNumber)){
                unique = false;
                break;
            }
            else {
                tempBanks.add(bank.accountNumber)
            }
        }
        assertThat(unique).isTrue
    }

    @Test
    fun `should provide some mock data`() {

        //act
        val banks = mockDataSource.retrieveBanks()

        //assert
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).anyMatch { it.transactionFee != 0}
    }
}