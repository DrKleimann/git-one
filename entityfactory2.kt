import java.util.*

//Singleton Thread Safety in Kotlin

enum class EntityType{
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize() //converts to lowercase
}

object EntityFactory2 {
    fun create(type: EntityType) : Entity2 {
        val id = UUID.randomUUID().toString() //creates a random ID
        val name = when(type){
//            EntityType.EASY -> "Easy"
//            EntityType.MEDIUM -> "Medium"
//            EntityType.HARD -> "Hard"
            EntityType.EASY -> type.name //references the actual nae of the ENUM
            EntityType.MEDIUM -> type.getFormattedName() //formats the name to lowercase
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
//        return Entity2(id, name)
          return when (type)
          {
              EntityType.EASY -> Entity2.Easy(id, name)
              EntityType.MEDIUM -> Entity2.Medium(id, name)
              EntityType.HARD -> Entity2.Hard(id, name, multiplier = 2f)
              EntityType.HELP -> Entity2.Help
          }
    }
}

//class Entity2(val id: String, val name: String) { //factories (constructors in short)
//    override fun toString(): String {
//        return "id:$id name:$name"
//    }
//}

sealed class Entity2() {
    object Help : Entity2() {
        val name = "Help"
    }

    data class Easy(val id: String, val name: String): Entity2()
    data class Medium(val id: String, val name: String): Entity2()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity2()
}

fun main(){

    val entity:Entity2 = EntityFactory2.create(EntityType.EASY)
    val msg = when (entity){
        Entity2.Help -> "help class"
        is Entity2.Easy -> "easy class"
        is Entity2.Medium -> "medium class"
        is Entity2.Hard -> "hard class"
    }

    println(msg)


//    val entity = EntityFactory2.create(EntityType.EASY)
//    println(entity)

//    val mediumentity = EntityFactory2.create(EntityType.MEDIUM)
//    println(mediumentity)
}

// Hashcode
// dataclass
// referential comparison "==="
// override