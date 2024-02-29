var name: String = "Balaba Sofya"
var helloWord: String = "Hello"
def printHelloMessage(): Unit = println(s"$helloWord Scala! This is $name")
printHelloMessage()
name = name.reverse
helloWord = "Hola"
printHelloMessage()