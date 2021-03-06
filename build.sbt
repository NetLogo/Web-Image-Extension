import AssemblyKeys._

scalaVersion := "2.9.3"

scalaSource in Compile <<= baseDirectory(_ / "src")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xlint", "-Xfatal-warnings", "-encoding", "us-ascii")

libraryDependencies ++= Seq(
  "org.nlogo" % "NetLogo" % "5.0.4" from
    "http://ccl.northwestern.edu/netlogo/5.0.4/NetLogo.jar",
  "commons-codec" % "commons-codec" % "1.8"
)

name := "web-image"

NetLogoExtension.settings

NetLogoExtension.classManager := "org.nlogo.extensions.webimage.WebImageExtension"

assemblySettings

jarName in assembly <<= name map (_ + ".jar")

assembleArtifact in packageScala := false

excludedJars in assembly <<= (fullClasspath in assembly) map (_ filter (_.data.getName.contains("NetLogo")))
