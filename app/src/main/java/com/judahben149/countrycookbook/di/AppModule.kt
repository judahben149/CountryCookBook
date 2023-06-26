package com.judahben149.countrycookbook.di

import com.apollographql.apollo3.ApolloClient
import com.judahben149.countrycookbook.data.network.ApolloCountryClient
import com.judahben149.countrycookbook.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApolloCountryClient(apolloClient: ApolloClient): ApolloCountryClient {
        return ApolloCountryClient(apolloClient)
    }

    fun providesCountryRepository(apolloCountryClient: ApolloCountryClient): MainRepository {
        return MainRepository(apolloCountryClient)
    }
}