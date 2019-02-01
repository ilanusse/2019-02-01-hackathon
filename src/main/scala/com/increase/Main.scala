package com.increase

import org.joda.time._
import org.apache.spark.sql.SparkSession
import com.increase.utils.Log

import scala.io.{BufferedSource, Source}
import scala.util.parsing.json._


object Main {
  def main(args: Array[String]) {
    Log.print("Started Spark Job")

    val sparkSession = SparkSession
      .builder
      .appName("Hackathon")
      .getOrCreate()

    import sparkSession.implicits._

    Log.print("Finished Spark Job")
    sparkSession.stop
  }
}
