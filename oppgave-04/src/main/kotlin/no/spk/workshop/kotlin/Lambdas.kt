package no.spk.workshop.kotlin


object Lambdas {

    fun helloGreeting(): (String) -> String {
        return { name: String -> "Hello, $name!" }
    }

    fun sum(): (Int, Int) -> Int {
        return { a: Int, b: Int -> a + b }
    }

    private final val n = 5

    fun sumWithN(): (Int) -> Int {
        return { a: Int -> a + n }
    }

    fun times(): (Int) -> (Int) -> Int {
        return { a: Int -> { b: Int -> a * b } }
    }
}
