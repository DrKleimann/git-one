fun getGreeting(): String // <- Return type
{
    return "Hello User"
}

fun sayHello(itemToGreet:String)
{
    val msg = "Hello " + itemToGreet
    val msg1 = "Hello $itemToGreet"
    println(msg)
}

fun sayHello2(Greeting:String, itemToGreet:String) = println("$Greeting $itemToGreet")


fun sayHello3(greeting2:String, itemsToGreet:List<String>)
{
    itemsToGreet.forEach{ itemsToGreet ->
        println("$greeting2 $itemsToGreet")
    }
}

fun sayHello4(greeting2:String, vararg itemsToGreet:String) //Basically 2nd argument is not mandatory and will be considered as empty if not received
{
    itemsToGreet.forEach{ itemsToGreet ->
        println("$greeting2 $itemsToGreet")
    }
}

fun main() {
    var Age = 12 //Kotlin automatically determines data type according to value given (this one is int)
    var test1: String = "Nate" //can be defined multiple times (mutable/non-null value)
    val test2: String = "Ethan" //can only be defined once (unmutable/non-null value)
    val test3: String? = "Wankers" //can only be defined once (unmutable/nullable value)

    println(getGreeting())
    sayHello(test1)
    sayHello2("Hi",test1)

    if (test1 == "Nate")
    {
    }
    else
    {
    }

    when(test1) //acts as a switch statement
    {
        "Nate" -> println("hi")
        else -> println(test1) //default choice
    }

    val TEST1CONFRIM = if(test1 != "Nate") test1 else "It's equal"
    println(TEST1CONFRIM)

    ///////////////////////// ARRAYS

    val interestingThings = arrayOf("Kotlin","Programming","Comic Books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))

    for (interestingThing in interestingThings)
    {
        println(interestingThing)
    }

    interestingThings.forEach {
        println(it) //"it" is the default name for passed values in the array
    }

    interestingThings.forEach { interestingThing ->
        println(interestingThing) //"it" is the default name for passed values in the array
    }

    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    ///////////////////////// LISTS

    val interestingThings2 = listOf("Kotlin","Programming","Comic Books")
    interestingThings2.forEach{ interestinThing ->
        println(interestinThing)
    }

    ///////////////////////// MAPS

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { key, value -> println("$key -> $value") }

    /////////////////////////
    val sample1 = listOf("Kotlin","Programming","Comic Books") //this is unmutable (can't add or remove values)
    val sample2 = mutableListOf("Kotlin","Programming","Comic Books") //mutable (can add or remove)
    /////////////////////////

    sayHello3(greeting2 = "Hi", interestingThings2)
    sayHello4(greeting2 = "hi no var 2")
    sayHello4(greeting2 = "hi arrayof", itemsToGreet = arrayOf("Kotlin","Programming","Comic Books"))
    sayHello4(greeting2 = "hi interesting", itemsToGreet = interestingThings)

    val person = Person(firstname = "Ethan",lastname = "Winters")
    person.lastname //Getters only because it's a "val" (read only)
    person.firstname
    person.nickName = "Shades" //Setter and Getter because it's a "var"
    person.nickName = "Shawn"
    println(person.nickName)
    person.printinfo() //method call

    Dummy()
}
