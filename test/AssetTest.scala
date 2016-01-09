import models.Asset
import org.junit.{Before, Test, Assert}

/**
 * Created on 02/01/16.
 */
class AssetTest {

    val historical_returns = List(1.0, 2.0, 3.0)
    val asset = new Asset("test01", historical_returns);

    @Test
    def expected_returns: Unit = {
        Assert.assertEquals(List(1.0, 0.5), asset.expected_returns);
    }

    @Test
    def average: Unit = {
        Assert.assertEquals(0.75, asset.average, 0.0001);
    }

    @Test
    def variance: Unit = {
        Assert.assertEquals(0.125, asset.variance, 0.0001);
    }

    @Test
    def std_dev: Unit = {
        Assert.assertEquals(0.353, asset.std_dev, 0.001);
    }

}
