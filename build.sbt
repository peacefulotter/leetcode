ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"

lazy val root = (project in file("."))
  .settings(
    name := "leetcode",
    idePackagePrefix := Some("com.peacefulotter.leetcode")
  )
