package co.devhack.backend.app.data.repository.course

import co.devhack.backend.app.data.entities.mapper.CourseEntityMapper
import co.devhack.backend.app.domain.models.Course
import co.devhack.backend.app.domain.repository.ICourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CourseRepository(@Autowired val mapper: CourseEntityMapper,
                       @Autowired val factory: CourseDataSourceFactory) : ICourseRepository {

    override fun getById(id: String): Course {
        val dataSource = factory.createCacheDataSource()
        return mapper.map(dataSource.getById(id)!!)
    }

    override fun getAll(): List<Course> {
        val dataSource = factory.createCacheDataSource()
        return mapper.map(dataSource.getAll())
    }

    override fun create(course: Course): Boolean {
        val dataSource = factory.createCacheDataSource()
        dataSource.addCourse(mapper.reverseMap(course))
        return true
    }
}