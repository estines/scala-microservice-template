ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val allotmentService = (project in file("."))
  .settings(
    name := "allotment_service",
    libraryDependencies ++= Seq(
    )
  )
