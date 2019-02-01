import org.scalatest._
import com.increase.job._
import com.increase.utils._
import scala.io.Source
import org.apache.spark.sql.SparkSession
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.Matchers._
import com.holdenkarau.spark.testing._
import org.scalacheck._
import org.apache.spark.sql.SQLContext._
import org.apache.spark.sql._
import collection._

class SparkJobSpec extends FlatSpec with BeforeAndAfter with MockitoSugar with SharedSparkContext {

  var sparkSession : SparkSession = _

  before {
    sparkSession = SparkSession.builder().master("local").appName("spark session").getOrCreate()
  }

  it should "run test" in {
    assert(new SparkJob(sparkSession).run() == 1)
  }
}
