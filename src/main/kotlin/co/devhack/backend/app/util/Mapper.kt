package co.devhack.backend.app.util

abstract class Mapper<T, V> {

    abstract fun map(value: T): V

    abstract fun reverseMap(value: V): T

    fun map(lstValue: List<T>): List<V> {
        val lstV = mutableListOf<V>()
        lstValue.forEach { lstV.add(map(it)) }
        return lstV
    }

    fun reverseMap(lstValue: List<V>): List<T> {
        val lstT = mutableListOf<T>()
        lstValue.forEach { lstT.add(reverseMap(it)) }
        return lstT
    }


}