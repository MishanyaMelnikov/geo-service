package LocalizationTest;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocationTest {


    @Test

     void locationTest(){
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.<Country>any())).thenReturn("RUSSIA");
    }
}
