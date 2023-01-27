package ru.netology.i18n;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {


    @Test

     void locationTest(){

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String actual = localizationService.locale(Country.valueOf("RUSSIA"));

        String expected = "Добро пожаловать";

        Assertions.assertEquals(actual, expected);



    }
}
