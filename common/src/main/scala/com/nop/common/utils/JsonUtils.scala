package com.nop.common.utils

import io.circe._
import io.circe.parser._

object JsonUtils {
  implicit class EnhancedJson(json: Json) {
    def getAsString(field: String): Option[String] =
      json.hcursor.downField(field).as[String].toOption

    def getAsInt(field: String): Option[Int] =
      json.hcursor.downField(field).as[Int].toOption

    def getAsDouble(field: String): Option[Double] =
      json.hcursor.downField(field).as[Double].toOption

    def getAsBoolean(field: String): Option[Boolean] =
      json.hcursor.downField(field).as[Boolean].toOption

    def getAsArray[T](field: String)(implicit decoder: Decoder[T]): Option[List[T]] =
      json.hcursor.downField(field).as[List[T]].toOption

    def getAsObject(field: String): Option[JsonObject] =
      json.hcursor.downField(field).as[JsonObject].toOption

    def hasField(field: String): Boolean =
      json.hcursor.downField(field).succeeded

    def extractField(field: String): Json =
      json.hcursor.downField(field).focus.getOrElse(Json.Null)
  }

//  implicit class EnhancedJsonObject(jsonObject: JsonObject) {
//    def getAsString(field: String): Option[String] =
//      jsonObject(field).flatMap(_.asString)
//
//    def getAsInt(field: String): Option[Int] =
//      jsonObject(field).flatMap(_.asNumber).flatMap(_.toInt)
//
//    def getAsDouble(field: String): Option[Double] =
//      jsonObject(field).flatMap(_.asNumber).flatMap(_.toDouble)
//
//    def getAsBoolean(field: String): Option[Boolean] =
//      jsonObject(field).flatMap(_.asBoolean)
//
//    def getAsArray[T](field: String)(implicit decoder: Decoder[T]): Option[List[T]] =
//      jsonObject(field).flatMap(_.asArray).flatMap(_.toList.traverse(decoder.decodeJson)).toOption
//
//    def getAsObject(field: String): Option[JsonObject] =
//      jsonObject(field).flatMap(_.asObject)
//
//    def hasField(field: String): Boolean =
//      jsonObject.keys.exists(_.equalsIgnoreCase(field))
//
//    def extractField(field: String): Json =
//      jsonObject(field).getOrElse(Json.Null)
//  }

  def example(): Unit = {
    val jsonString =
      """
    {
      "name": "Eve",
      "age": 28,
      "is_active": true,
      "scores": [90, 85, 92],
      "address": {
        "city": "New York",
        "zip": "10001"
      }
    }
    """

    val jsonObject = parse(jsonString).getOrElse(Json.Null)

    val isActive = jsonObject.getAsBoolean("is_active") // Some(true)
    val scores = jsonObject.getAsArray[Int]("scores") // Some(List(90, 85, 92))
    val address = jsonObject.getAsObject("address").getOrElse(Json.Null)
//    println(address.getAsString("city")) // Some("New York")
  }
}
