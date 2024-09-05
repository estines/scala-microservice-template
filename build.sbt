ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file(".")).aggregate(common) // List your microservices here
lazy val common = (project in file("common"))
lazy val allotmentService = (project in file("allotment_service")).dependsOn(common)
