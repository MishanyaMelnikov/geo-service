package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.Map;

public class MessageSenderImplTest {

    @Test

    public void RusSenderTest(){

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.valueOf("RUSSIA"))).thenReturn("Добро пожаловать");



        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String preferences = messageSender.send(Map.of("x-real-ip","172.0.32.11"));
        String expected = "Добро пожаловать";

        Assertions.assertEquals(preferences, expected);


    }

    @Test

    public void EngSenderTest(){

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");



        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String preferences = messageSender.send(Map.of("x-real-ip","96.44.183.149"));
        String expected = "Welcome";

        Assertions.assertEquals(preferences, expected);


    }
}
