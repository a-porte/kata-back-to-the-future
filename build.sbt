lazy val root = (project in file("."))
  .settings(
    name := "kata-back-to-the-future",
    version := "0.1",

    scalaVersion := "3.1.0",

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.16" % "test",
      "com.lihaoyi" %% "os-lib" % "0.9.3"
    ),

    scalacOptions ++= Seq("-Xfatal-warnings")
  )
