name := "SparkTest"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.0.0"
val sparkDependencyScope = "provided"

resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.0.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "graphframes" % "graphframes" % "0.2.0-spark2.0-s_2.10" % "provided",
  "org.apache.spark" % "spark-sql_2.11" % "2.0.0",
  "org.apache.spark" % "spark-graphx_2.11" % "2.0.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.0.0"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}