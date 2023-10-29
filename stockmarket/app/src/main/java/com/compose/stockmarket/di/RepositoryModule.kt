package com.compose.stockmarket.di

import com.compose.stockmarket.data.csv.CSVParser
import com.compose.stockmarket.data.csv.CompanyListingsParser
import com.compose.stockmarket.data.csv.IntradayInfoParser
import com.compose.stockmarket.data.repository.StockRepositoryImpl
import com.compose.stockmarket.domain.model.CompanyListing
import com.compose.stockmarket.domain.model.IntradayInfo
import com.compose.stockmarket.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}