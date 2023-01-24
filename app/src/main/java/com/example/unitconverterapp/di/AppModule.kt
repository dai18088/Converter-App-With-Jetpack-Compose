package com.example.unitconverterapp.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverterapp.data.ConverterDatabase
import com.example.unitconverterapp.data.ConverterRepository
import com.example.unitconverterapp.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideConverterDatabase(app: Application): ConverterDatabase{
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            "converter_data_base"
        ).build()
    }

    @Singleton
    @Provides
    fun provideConverterRepository(db: ConverterDatabase): ConverterRepository{
        return ConverterRepositoryImpl(db.converterDAO)
    }

}