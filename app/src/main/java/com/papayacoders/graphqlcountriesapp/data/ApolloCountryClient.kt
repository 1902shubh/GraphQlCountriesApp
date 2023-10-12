package com.papayacoders.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.papayacoders.CountriesQuery
import com.papayacoders.CountryQuery
import com.papayacoders.graphqlcountriesapp.domain.CountryClient
import com.papayacoders.graphqlcountriesapp.domain.DetailedCountry
import com.papayacoders.graphqlcountriesapp.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient

) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {

        return apolloClient.query(CountryQuery(code))
            .execute()
            .data?.country
            ?.toDetailedCountry()
    }

}