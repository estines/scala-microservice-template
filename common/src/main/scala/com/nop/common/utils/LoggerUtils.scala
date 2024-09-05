package com.nop.common.utils

import org.slf4j.LoggerFactory

trait LoggerUtils {
  private val logger = LoggerFactory.getLogger(this.getClass)

  def trace[T](message: String)(block: => T): T = {
    val startTime = System.currentTimeMillis()
    logger.info(s"Entering: $message")

    try {
      val result = block
      val endTime = System.currentTimeMillis()
      val duration = endTime - startTime
      logger.info(s"Exiting: $message (Duration: ${duration}ms)")
      result
    } catch {
      case e: Exception =>
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        logger.error(s"Exiting with Error: $message (Duration: ${duration}ms)", e)
        throw e
    }
  }
}