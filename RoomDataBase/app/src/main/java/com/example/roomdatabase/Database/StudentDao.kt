package com.example.roomdatabase.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.com.example.roomdatabase.database.StudentDetails

@Dao
interface StudentDao {

    @Insert
    fun insert(studentDetails: StudentDetails)

    @Query("select * from student_details")
    fun getAll() : LiveData<List<StudentDetails>>
}