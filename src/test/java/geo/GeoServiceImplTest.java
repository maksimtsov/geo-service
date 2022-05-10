package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @Test
    public void byIpTest() {
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Location result = geoService.byIp("172.01.34.11");

        Assertions.assertEquals(expected.getCountry(), result.getCountry());
    }
}
