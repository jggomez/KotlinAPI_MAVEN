package co.devhack.backend.app.data.repository.course

import org.springframework.stereotype.Component

@Component
class CourseDataSourceFactory {

    fun createCacheDataSource(): ICourseDataSource {
        return CacheDataSource()
    }
}