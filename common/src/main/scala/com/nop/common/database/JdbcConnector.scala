package com.nop.common.database

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object JdbcConnector {

  /**
   * Helper method to establish a JDBC connection and read data into a DataFrame.
   *
   * @param spark      The SparkSession instance.
   * @param url        JDBC connection URL.
   * @param table      Database table name.
   * @param driver     JDBC driver class name.
   * @param properties Optional JDBC connection properties.
   * @return DataFrame containing data read from the JDBC source.
   */
  def readData(spark: SparkSession, url: String, table: String, driver: String): DataFrame = {
    spark.read.format("jdbc").options(Map("url" -> url, "dbtable" -> table, "driver" -> driver)).load()
    //    spark.read
    //      .format("jdbc")
    //      .option("url", url)
    //      .option("dbtable", table)
    //      .option("driver", driver)
    //      .options(properties)
    //      .load()
    //    println("yeah")
  }

  /**
   * Helper method to write a DataFrame to a JDBC sink.
   *
   * @param dataFrame  The DataFrame to write.
   * @param url        JDBC connection URL.
   * @param table      Database table name.
   * @param driver     JDBC driver class name.
   * @param mode       Write mode (e.g., "append", "overwrite").
   * @param properties Optional JDBC connection properties.
   */
  def writeData(dataFrame: DataFrame, url: String, table: String, driver: String, mode: String = "append"): Unit = {
    dataFrame.write
      .format("jdbc")
      .options(Map("url" -> url, "dbtable" -> table, "driver" -> driver))
      .mode(SaveMode.Overwrite)
      .save()
  }
}