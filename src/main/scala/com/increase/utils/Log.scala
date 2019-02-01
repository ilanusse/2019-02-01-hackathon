package com.increase.utils

import org.joda.time._

object Log {
  def print(message: String) {
    val now = new DateTime
    println(s"[${now}][INFO] ${message}")
  }

  def printError(message: String) {
    val now = new DateTime
    println(s"[${now}][ERROR] ${message}")
  }
}
