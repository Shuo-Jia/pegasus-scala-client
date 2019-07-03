version := "1.11.4-1-SNAPSHOT"

organization := "com.xiaomi.infra"

name := "pegasus-scala-client"

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.11.7", "2.12.7")

publishMavenStyle := true

//custom repository
resolvers ++= Seq(
    "Remote Maven Repository" at "http://your-url/",
    "Local Maven Repository" at "file://your-url/"
)

//custom publish url
publishTo := {
    val nexus = "http://your-url/"
    if (isSnapshot.value) Some("snapshots" at nexus + "snapshots") else Some("releases" at nexus + "releases")
}

credentials += Credentials(new File((Path.userHome / ".sbt" / ".credentials").toString()))

libraryDependencies ++= Seq(
    "com.google.guava" % "guava" % "20.0",
    "com.xiaomi.infra" % "pegasus-client" % "1.11.5-thrift-0.11.0-inlined",
    "org.scalatest" %% "scalatest" % "3.0.3" % Test
)
