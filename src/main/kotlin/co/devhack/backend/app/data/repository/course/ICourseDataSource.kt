package co.devhack.backend.app.data.repository.course

import co.devhack.backend.app.data.entities.CourseEntity

interface ICourseDataSource {

    fun addCourse(course: CourseEntity): Boolean

    fun getById(id: String): CourseEntity?

    fun getAll(): List<CourseEntity>
}