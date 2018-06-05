package co.devhack.backend.app.data.entities.mapper

import co.devhack.backend.app.data.entities.CourseEntity
import co.devhack.backend.app.domain.models.Course
import co.devhack.backend.app.util.Mapper
import org.springframework.stereotype.Component

@Component
class CourseEntityMapper : Mapper<CourseEntity, Course>() {

    override fun map(value: CourseEntity): Course {
        return Course("", value.name, value.description, value.date)
    }

    override fun reverseMap(value: Course): CourseEntity {
        return CourseEntity("", value.name, value.description, value.date)
    }
}