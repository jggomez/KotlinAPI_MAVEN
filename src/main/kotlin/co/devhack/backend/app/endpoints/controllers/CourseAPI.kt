package co.devhack.backend.app.endpoints.controllers

import co.devhack.backend.app.domain.usecase.course.CreateCourseUseCase
import co.devhack.backend.app.domain.usecase.course.GetAllCourseUseCase
import co.devhack.backend.app.domain.usecase.course.GetCourseById
import co.devhack.backend.app.endpoints.DTOmodels.DTOCourse
import co.devhack.backend.app.endpoints.DTOmodels.mapper.DTOCourseMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CourseAPI {

    @Autowired
    private lateinit var createCourseUsecase: CreateCourseUseCase

    @Autowired
    private lateinit var getAllCourseUseCase: GetAllCourseUseCase

    @Autowired
    private lateinit var mapper: DTOCourseMapper

    @Autowired
    private lateinit var getCourseById: GetCourseById


    @RequestMapping("api/courses", method = arrayOf(RequestMethod.GET))
    fun getAllCourses() = getAllCourseUseCase.execute()

    @RequestMapping("api/courses", method = arrayOf(RequestMethod.POST))
    fun addCourse(@RequestBody dtoCourse: DTOCourse): Boolean {
        createCourseUsecase.setCourse(mapper.reverseMap(dtoCourse))
        return createCourseUsecase.execute()
    }

    @RequestMapping("api/courses/{id}", method = arrayOf(RequestMethod.GET))
    fun getById(@PathVariable("id") id: String): DTOCourse {
        getCourseById.setId(id)
        return mapper.map(getCourseById.execute()!!)
    }

}