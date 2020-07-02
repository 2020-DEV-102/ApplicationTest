package com.example.applicationtest.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.applicationtest.database.entities.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    fun getAll(): LiveData<Array<Character>>

    /*@Query("SELECT * FROM character WHERE cid IN (:characterIds)")
    fun loadAllByIds(characterIds: IntArray): List<Character>*/

    /*@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Character*/

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters: Array<Character>)*/

    @Query("SELECT * FROM character WHERE cid=:characterId")
    suspend fun findById(characterId: Int): Character

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg characters: Character)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: Character)

    @Delete
    fun delete(character: Character)
}