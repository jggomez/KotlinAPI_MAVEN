package co.devhack.backend.app.data.repository.course

import co.devhack.backend.app.data.entities.CourseEntity

class CacheDataSource : ICourseDataSource {

    companion object {
        val courses = mutableListOf<CourseEntity>()
    }

    override fun addCourse(course: CourseEntity): Boolean {
        courses.add(course)
        return true
    }

    override fun getById(id: String): CourseEntity? {
        var course: CourseEntity? = null
        courses.firstOrNull { it.id == id }?.let {
            course = it
        }
        return course
    }

    override fun getAll(): List<CourseEntity> {
        return courses
    }
}