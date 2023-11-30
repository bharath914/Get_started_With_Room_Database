package com.bharath.roomguide.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bharath.roomguide.data.datasource.MyDao
import com.bharath.roomguide.data.entity.StudentEntity

@Database(
    entities = [StudentEntity::class],
    version = 1
)
abstract class MyDatabase :RoomDatabase(){
    abstract val dao: MyDao
}