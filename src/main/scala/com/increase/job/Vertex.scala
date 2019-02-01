package com.increase.job

trait Vertex
case class CustomerVertex(val card_number: String) extends Vertex
case class ShopVertex(val id: String) extends Vertex
