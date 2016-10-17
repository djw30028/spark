import scala.math.random

import org.apache.spark.sql.SparkSession

/**
  * Created by michaelwang on 10/16/16.
  *
  * sbt assembly
  *
  * /Users/michaelwang/myprogs/spark-2.0.0-bin-hadoop2.7
  * ./bin/spark-submit --class "SparkPi" --master local[4] /Users/michaelwang/project/mypractice/SparkTest/target/scala-2.11/SparkTest-assembly-1.0.jar
    Note: need to comment out .master("local")

  *  with ./bin/spark-shell
  *  need to set .master("local")
  */
object SparkPi {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("SparkPi")
      //.master("local")
      .getOrCreate()

    val slices = if (args.length > 0) args(0).toInt else 2
    val n = math.min(100000L * slices, Int.MaxValue).toInt // avoid overflow
    val count = spark.sparkContext.parallelize(1 until n, slices).map { i =>
      val x = random * 2 - 1
      val y = random * 2 - 1
      if (x*x + y*y < 1) 1 else 0
    }.reduce(_ + _)
    println(" **** Pi is roughly " + 4.0 * count / (n - 1))
    spark.stop()
  }
}