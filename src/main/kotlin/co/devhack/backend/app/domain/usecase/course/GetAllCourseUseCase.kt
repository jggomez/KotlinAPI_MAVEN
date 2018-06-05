package co.devhack.backend.app.domain.usecase.course

import co.devhack.backend.app.domain.models.Course
import co.devhack.backend.app.domain.repository.ICourseRepository
import co.devhack.backend.app.domain.usecase.UseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetAllCourseUseCase(@Autowired val courseRepository: ICourseRepository)
    : UseCase<List<Course>> {

    override fun execute(): List<Course> {
        return courseRepository.getAll()
    }
}