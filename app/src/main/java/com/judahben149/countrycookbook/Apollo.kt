package com.judahben149.countrycookbook

import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://countries.trevorblades.com")
    .build()
