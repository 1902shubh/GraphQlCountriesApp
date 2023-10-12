package com.papayacoders.graphqlcountriesapp.data

import com.papayacoders.CountriesQuery
import com.papayacoders.CountryQuery
import com.papayacoders.graphqlcountriesapp.domain.DetailedCountry
import com.papayacoders.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code,
        name,
        emoji,
        capital ?: "No Capital",
        currency ?: "no Currency",
        languages.mapNotNull { it.name },
        continent.name
    )
}
fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code,
        name,
        emoji,
        capital ?: "No Capital",
    )
}