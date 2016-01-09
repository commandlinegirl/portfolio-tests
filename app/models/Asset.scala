package models

/**
 * Created on 26/12/15.
 */
class Asset(name: String, historical_data: List[Double]) {

    val expected_returns =
        historical_data.sliding(2).collect{ case List(a, b) => (a, b)}.toList
          .map(x => (x._2 - x._1) / x._1)

    override def toString(): String = "Asset(" + name + ")"

    def average: Double = {
        expected_returns.sum / expected_returns.length
    }

    def std_dev: Double = {
        math.sqrt(variance)
    }

    /* Online variance algorithm */
    def variance: Double = {
        var n = 0
        var mean = 0.0
        var M2 = 0.0

        for (x <- expected_returns) {
            n += 1
            val delta = x - mean
            mean += delta / n
            M2 += delta * (x - mean)
        }

        if (n < 2) 0
        else M2 / (n - 1)
    }

}
