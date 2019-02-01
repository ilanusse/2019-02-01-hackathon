import Dependencies._

scalacOptions += "-deprecation"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.increase",
      scalaVersion := "2.11.11",
      version      := "0.1.0-SNAPSHOT"
    )),

    mainClass in (Compile, run) := Some("com.increase.Main"),

    name := "Hackathon",
    parallelExecution in ThisBuild := false,
    parallelExecution in Test := false,
    resolvers += "Spark Packages Repo" at "https://dl.bintray.com/spark-packages/maven",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.holdenkarau" %% "spark-testing-base" % "2.2.0_0.8.0" % Test,
      "org.mockito" % "mockito-core" % "1.8.5" % Test,
      "org.scala-debugger" %% "scala-debugger-api" % "1.1.0-M3",
      "org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
      "org.apache.spark" %% "spark-sql" % "2.2.0" % "provided",
      "org.apache.spark" %% "spark-graphx" % "2.2.0" % "provided",
      "org.apache.hadoop" % "hadoop-aws" % "2.6.0" % "provided"
    )
  )

// META-INF discarding
assemblyMergeStrategy in assembly := {
  {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
}
