class Person (val firstname: String = "Peter",val lastname: String = "Parker"){ //THIS line alone nullifies the entire grey comment

      var nickName: String? = null

      set(value) { //acts as a log whenever a setter is called
            field = value
            println("the new nickname is $value")
      }
      get(){
            println("the returned value is $field")
            return field
      }
//    val firstname: String = firstname
//    val lastname: String = lastname
//
//    init { // inits always execute first than secondary constructor
//        println("init 1")
//    }
//    constructor(): this("Peter","Parker") // SECONDARY CONSTRUCTOR
//    {
//        println("secondary constructor")
//    }
//    init {
//        println("init 2")
//    }
      fun printinfo() { // METHOD
       val nickNameToPrint = nickName ?: "no nickname" //Same as below
//            val nickNameToPrint = if(nickName != null) nickName else "no nickname"
            println("$firstname ($nickNameToPrint) $lastname")
      }
}