interface PersoninfoProvider{ //interface 1
    val providerInfo : String // Property initializer

    fun printInfo(person: Person){
        println(providerInfo)
        person.printinfo()
    }
}

interface SessioninfoProvider{ //interface 2
    fun getSessionId() : String
}

open class BassicInfoProvider : PersoninfoProvider, SessioninfoProvider { // <- implements //"Open" keyword makes it inheritable (public)
    override val providerInfo: String
        get() = "BasicInfoProvider"

    protected open val sessionIdPrefix = "Session" //Open also applies to vals/vars,
    // "protected makes it so that classes in here don't access this without inheritance

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
//    override fun printInfo(person: Person) {
//        println("basicInfoProvider")
//        person.printinfo()
//    }
}

fun main() {
    var provider = BassicInfoProvider()
    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)

    provider = FancyInfoProvider()
    provider.printInfo(Person())
    provider.getSessionId()

    val provider2 = object : PersoninfoProvider { //create an object from an interface and even override its properties (Annonymous inner class
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id"
    }

    provider2.printInfo(Person())
    provider2.getSessionId()
}

fun checkTypes(infoProvider: PersoninfoProvider) { //TYPECHECKING & TYPECASTING

    if(infoProvider !is SessioninfoProvider){ //<- TypeChecking
        println("not a session info provider")
    }
    else{
        println("is a session info provider")
        //(infoProvider as SessioninfoProvider).getSessionId() //TypeCasting
        infoProvider.getSessionId() //SmartCast because infoProvider IS a SessioninfoProvider
    }
}