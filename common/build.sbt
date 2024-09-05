ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val common = (project in file("."))
  .settings(
    name := "common",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % "0.14.3",
      "io.circe" %% "circe-parser" % "0.14.3",
      ("org.apache.spark" %% "spark-core" % "3.3.1").cross(CrossVersion.for3Use2_13),
      ("org.apache.spark" %% "spark-sql" % "3.3.1").cross(CrossVersion.for3Use2_13),
      "com.github.scopt" %% "scopt" % "4.1.0",
    )
  )
