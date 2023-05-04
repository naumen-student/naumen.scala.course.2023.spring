name := "homework_7"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies += "com.lihaoyi" %% "utest" % "0.5.3" % "test"

scalacOptions ++= Seq("-language:higherKinds")

testFrameworks += new TestFramework("utest.runner.Framework")