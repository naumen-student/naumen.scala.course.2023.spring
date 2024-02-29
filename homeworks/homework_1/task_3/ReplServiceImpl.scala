class ReplServiceImpl(var helloWord: String, var name: String)  extends ReplService {
  override def print(): Unit = println(s"$helloWord Scala! This is $name")
}
