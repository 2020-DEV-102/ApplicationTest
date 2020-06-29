package com.example.applicationtest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applicationtest.database.daos.CharacterDao
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.utilities.SingletonHolder

@Database(entities = arrayOf(Character::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao() : CharacterDao

    /*companion object : SingletonHolder<AppDatabase, Context>({
        Room.databaseBuilder(it.applicationContext, AppDatabase::class.java, "game_database.db").build()
    })*/
}