import java.util.*

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFooda (day : String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

fun fishFoodb (day : String) : String {
    val food : String
    when (day) {
        "Monday" -> food = "flakes"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
    return food
}

fun fishFoodc (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    }
}

fun shouldChangeWater2 (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun feedTheFish() {
    val day = randomDay()
//    val food = "pellets"
//    val food = fishFooda(day)
//    val food = fishFoodb(day)
    val food = fishFoodc(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
    println("Change water: ${shouldChangeWater2(day)}")
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)

    feedTheFish()

    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter

//  -------------- FILTERS --------------
    println( decorations.filter {it[0] == 'p'})

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")


//    -------------- LAMBDA FUNCTIONS --------------
    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter2(dirtyLevel))

//    -------------- HIGHER ORDER FUNCTION --------------
    val waterFilter3: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter3))

    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel2 = 19
    dirtyLevel2 = updateDirty(dirtyLevel2) { dirtyLevel2 -> dirtyLevel2 + 23}
    println(dirtyLevel2)


}

