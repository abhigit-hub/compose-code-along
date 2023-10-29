package com.compose.stockmarket.presentation.companyinfo

import com.compose.stockmarket.domain.model.CompanyInfo
import com.compose.stockmarket.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
