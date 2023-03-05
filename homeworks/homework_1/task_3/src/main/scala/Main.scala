object Main extends App {
  var name = "Arsen Huranov"
  var hello1 = "Hello"
  var hello2 = "Guten tag"
  var hello3 = "Hola"
  var message = " Scala! This is "
  var printmessage = (hello: String, name: String) => println(hello+" Scala! This is "+name)
  printmessage(hello1, name)
  printmessage(hello2, name)
  printmessage(hello3, name)
  printmessage(hello1, name.reverse)
  printmessage(hello2, name.reverse)
  printmessage(hello3, name.reverse)
}
