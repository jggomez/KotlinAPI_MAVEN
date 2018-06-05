package co.devhack.backend.app.domain.usecase.course

import co.devhack.backend.app.domain.models.Course
import co.devhack.backend.app.domain.repository.ICourseRepository
import co.devhack.backend.app.domain.usecase.UseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetCourseById(@Autowired val courseRepository: ICourseRepository) : UseCase<Course?> {

    private lateinit var id: String

    fun setId(id: String) {
        this.id = id
    }

    override fun execute(): Course? {
        return courseRepository.getById(id)
    }
}