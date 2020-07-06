package com.example.applicationtest.modules

import androidx.room.Room
import com.example.applicationtest.database.AppDatabase
import com.example.applicationtest.repositories.CharacterRepository
import com.example.applicationtest.viewmodels.AddCharacterViewModel
import com.example.applicationtest.viewmodels.HomeViewModel
import com.example.applicationtest.utilities.Constants
import com.example.applicationtest.viewmodels.CharacterDetailViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, Constants.AppDatabase)
            .build()
    }
    single {
        get<AppDatabase>().characterDao()
    }
    single { CharacterRepository(get()) }

    viewModel { HomeViewModel(get()) }
    viewModel { AddCharacterViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
}