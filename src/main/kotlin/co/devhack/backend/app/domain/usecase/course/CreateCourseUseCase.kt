package co.devhack.backend.app.domain.usecase.course

import co.devhack.backend.app.domain.models.Course
import co.devhack.backend.app.domain.repository.ICourseRepository
import co.devhack.backend.app.domain.usecase.UseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class CreateCourseUseCase(@Autowired val courseRepository: ICourseRepository) : UseCase<Boolean> {


    override fun execute(): Boolean {
        return courseRepository.create(this.course)
    }

    private lateinit var course: Course

    fun setCourse(course: Course) {
        val uuid : UUID = UUID.randomUUID()
        this.course = course
        this.course.id = uuid.toString()
    }


}