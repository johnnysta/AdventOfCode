package day5;

import java.util.List;

public interface DataProvider {

    public List<Long> provideSeeds();

    public List<MapItem> provideSeedToSoilMap();

    public List<MapItem> provideSoilToFertilizerMap();

    public List<MapItem> provideFertilizerToWaterMap();

    public List<MapItem> provideWaterToLightMap();

    public List<MapItem> provideLightToTemperatureMap();

    public List<MapItem> provideTemperatureToHumidityMap();

    public List<MapItem> provideHumidityToLocationMap();
}
