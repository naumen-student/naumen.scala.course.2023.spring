ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "homework_8"
  )

libraryDependencies += "com.lihaoyi" %% "utest" % "0.8.1" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")