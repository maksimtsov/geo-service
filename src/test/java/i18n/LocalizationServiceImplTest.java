package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    public void LocalizationServiceTestRussia() {
        String expected = "Добро пожаловать";
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void LocalizationServiceTestOther() {
        String expected = "Welcome";
        String result = localizationService.locale(Country.BRAZIL);
        Assertions.assertEquals(expected, result);
    }
}
