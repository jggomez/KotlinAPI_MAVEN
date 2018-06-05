package co.devhack.backend.app.endpoints.DTOmodels.mapper

import co.devhack.backend.app.domain.models.Course
import co.devhack.backend.app.endpoints.DTOmodels.DTOCourse
import co.devhack.backend.app.util.Mapper
import org.springframework.stereotype.Component

@Component
class DTOCourseMapper : Mapper<Course, DTOCourse>() {

    override fun map(value: Course): DTOCourse {
        return DTOCourse(value.name, value.description, value.date)
    }

    override fun reverseMap(value: DTOCourse): Course {
        return Course("", value.name, value.description, value.date)
    }
}