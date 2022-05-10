package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessegeSenderTest {
    private final GeoService geoService = Mockito.mock(GeoServiceImpl.class);
    private final LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
    @Test
    public void sendRuTest() {
        Mockito.when(geoService.byIp(Mockito.startsWith("172")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.222.42.85");

        String expected = "Добро пожаловать";
        String result = messageSender.send(headers);

        Assertions.assertEquals(expected,result);
    }

    @Test
    public void sendEnTest() {
        Mockito.when(geoService.byIp(Mockito.startsWith("96")))
                .thenReturn(new Location("New York", Country.USA, null,  0));

        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.254.54.25");

        String expected = "Welcome";
        String result = messageSender.send(headers);

        Assertions.assertEquals(expected,result);
    }
}
