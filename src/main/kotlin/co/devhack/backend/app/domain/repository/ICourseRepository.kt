package co.devhack.backend.app.domain.repository

import co.devhack.backend.app.domain.models.Course

interface ICourseRepository {

    fun create(course: Course) : Boolean

    fun getById(id: String): Course

    fun getAll(): List<Course>

}