import org.apache.spark.sql.SparkSession

/**
  * Created by michaelwang on 10/16/16.
  */
object SparkWordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .master("local")
      .appName("Spark Graph Frames")
      .getOrCreate()

    val lines = spark.sparkContext.parallelize(Seq("Spark Intellij Idea Scala test one", "Spark Intellij Idea Scala test two", "Spark Intellij Idea Scala test three"))

    val counts = lines.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.foreach(println)

  }
}
