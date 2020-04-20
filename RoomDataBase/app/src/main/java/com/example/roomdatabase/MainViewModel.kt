package com.example.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabase.Database.StudentRepository
import com.example.roomdatabase.com.example.roomdatabase.database.StudentDetails

class MainViewModel(application: Application): AndroidViewModel(application)
{
    val studentRepository : StudentRepository
    val allStudents : LiveData<List<StudentDetails>>

    init {
        studentRepository = StudentRepository(application)
        allStudents = studentRepository.getAll()

    }

    fun insert(studentDetails: StudentDetails){
        studentRepository.insert(studentDetails)
    }
}