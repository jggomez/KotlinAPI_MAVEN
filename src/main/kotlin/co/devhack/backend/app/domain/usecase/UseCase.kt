package co.devhack.backend.app.domain.usecase

interface UseCase<T> {

    fun execute(): T

}