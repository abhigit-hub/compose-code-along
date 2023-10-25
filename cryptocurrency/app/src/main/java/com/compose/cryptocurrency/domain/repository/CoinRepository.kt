package com.compose.cryptocurrency.domain.repository

import com.compose.cryptocurrency.data.remote.dto.CoinDetailDto
import com.compose.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}