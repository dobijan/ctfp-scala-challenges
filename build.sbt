import Dependencies._

ThisBuild / scalaVersion     := "3.1.3"
ThisBuild / version          := "1.0"
ThisBuild / organization     := "jasek"
ThisBuild / organizationName := "ctfp"

lazy val root = (project in file("."))
  .settings(
    name := "ctfp-scala-challenges",
    libraryDependencies += scalaTest % Test
  )
