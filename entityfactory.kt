interface  IdProvider{
    fun getId(): String
}

class Entity private constructor(val id: String) { //factories (constructors in short)

    companion object Factory : IdProvider{ // Companion objects have access within private classes

        override fun getId(): String {
            return "123"
        }

        const val id = "id" // can store properties within companion objects
        fun create() = Entity(id)
        fun create2() = Entity(getId())



        //fun create() = Entity(id = "id")
    }
}

fun main(){
    //val entity = Entity.Companion.create() Java method
    //val entity = Entity.create() Kotlin method
    val entity = Entity.Factory.create() //More understandable method
    val entity2 = Entity.Factory.create2() //More understandable method
    Entity.id
}