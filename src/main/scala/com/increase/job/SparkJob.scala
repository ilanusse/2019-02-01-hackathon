package com.increase.job

import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD
import org.apache.spark.graphx._

class SparkJob(val sparkSession: SparkSession) {
  def run() = {
    val sc = sparkSession.sparkContext

    // Create an RDD for the vertices
    val customers: RDD[(VertexId, Vertex)] = sc.parallelize(Seq(
      (1L, CustomerVertex("4743177269340980")),
      (2L, CustomerVertex("4591808876230213"))
    ))

    val shops: RDD[(VertexId, Vertex)] = sc.parallelize(Seq(
      (1001L, ShopVertex("shop1")),
      (1002L, ShopVertex("shop2"))
    ))

    val vertices = VertexRDD(customers ++ shops)

    // Create an RDD for the edges
    val edges: RDD[Edge[Int]] = sc.parallelize(Array(
      Edge(1L, 1001L, 300),
      Edge(1L, 1001L, 400),
      Edge(1L, 1002L, 100),
      Edge(2L, 1002L, 400),
      Edge(2L, 1002L, 4000)
    ))

    // The graph might then have the type:
    val graph: Graph[Vertex, Int] = Graph(vertices, edges)
    1
  }
}
