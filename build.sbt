name := "2017-02-28-corkdev"

organization := "com.newsweaver.pi"

version := "0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= {
  val scalaTestVersion = "3.0.1"
  val scalaCheckVersion = "1.13.4"
  val jUnitInterfaceVersion = "0.11"
  // val jUnitVersion = "4.12"
  Seq(
    "com.novocode" % "junit-interface" % jUnitInterfaceVersion % "test",
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test",
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test")
    // "junit" % "junit" % "4.12" % "test")
}

val scalastyleFailOnError = true
