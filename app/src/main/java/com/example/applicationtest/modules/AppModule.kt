package com.example.applicationtest.modules

import androidx.room.Room
import com.example.applicationtest.database.AppDatabase
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.repositories.CharacterRepository
import com.example.applicationtest.ui.home.HomeViewModel
import com.example.applicationtest.utilities.Constants
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import java.lang.reflect.Modifier

val appModule = module {
    /*single {
        GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
            .serializeNulls()
            .registerTypeAdapter(Character::class.java, CoinTypeAdapter())
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }*/
    //single { CoinResultDeserializer(get()) }
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, Constants.AppDatabase)
            .build()
    }
    single {
        get<AppDatabase>().characterDao()
    }
    single { CharacterRepository(get()) }
    viewModel { HomeViewModel(get()) }
}