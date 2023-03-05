package com.prmncr.hello_world

object Main extends App {
  private val words = List("Hello", "Hola", "Guten tag")
  private val printer = (greeting: List[String], name: String) => greeting.foreach(it => println(f"$it Scala! This is $name"))
  printer(words, "Andrew Stremousov")
  printer(words, "Andrew Stremousov".reverse)
}