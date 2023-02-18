ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "hello_world",
    idePackagePrefix := Some("com.prmncr.hello_world")
  )
