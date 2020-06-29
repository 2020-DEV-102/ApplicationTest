package com.example.applicationtest.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.applicationtest.database.entities.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    fun getAll(): List<Character>

    /*@Query("SELECT * FROM character WHERE cid IN (:characterIds)")
    fun loadAllByIds(characterIds: IntArray): List<Character>*/

    /*@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Character*/

    /*@Insert
    fun insertAll(vararg characters: List<Character>)*/

    /*@Insert
    fun insertAll(vararg characters: Character)*/

    /*@Insert
    fun insertCharacter(vararg character: Character)*/

    @Delete
    fun delete(character: Character)
}