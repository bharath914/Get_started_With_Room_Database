package com.bharath.roomguide.data.repository

import com.bharath.roomguide.data.datasource.MyDao
import com.bharath.roomguide.data.entity.StudentEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*
Clean architecture pattern
good for separation of logic
 */

interface Repository {

    suspend fun insert(studentEntity: StudentEntity)

    suspend fun delete(studentEntity: StudentEntity)

    suspend fun update(studentEntity: StudentEntity)

    suspend fun getAllStudents(): Flow<List<StudentEntity>>
}

class RepositoryImpl @Inject constructor(
    private val dao: MyDao,
) : Repository {
    override suspend fun insert(studentEntity: StudentEntity) {
        withContext(IO) {
            dao.insert(studentEntity)
        }
    }

    override suspend fun delete(studentEntity: StudentEntity) {
        withContext(IO) {
            dao.delete(studentEntity)
        }
    }

    override suspend fun update(studentEntity: StudentEntity) {
        withContext(IO) {
            dao.update(studentEntity)
        }
    }

    override suspend fun getAllStudents(): Flow<List<StudentEntity>> {
        return withContext(IO) {
            dao.getAllStudents()
        }
    }

}