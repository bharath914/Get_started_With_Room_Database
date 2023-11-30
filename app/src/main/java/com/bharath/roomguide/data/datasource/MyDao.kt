package com.bharath.roomguide.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharath.roomguide.data.entity.StudentEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(studentEntity: StudentEntity)

    @Delete
    suspend fun delete(studentEntity: StudentEntity)

    @Update
    suspend fun update(studentEntity: StudentEntity)

    @Query("SELECT * FROM StudentEntity")
    fun getAllStudents(): Flow<List<StudentEntity>>
}