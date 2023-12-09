package day5;

import java.util.*;

public class Day5Part1 {

    private List<Long> seeds;
    private List<MapItem> seedToSoilMap;
    private List<MapItem> soilToFertilizerMap;
    private List<MapItem> fertilizerToWaterMap;
    private List<MapItem> waterToLightMap;
    private List<MapItem> lightToTemperatureMap;
    private List<MapItem> temperatureToHumidityMap;
    private List<MapItem> humidityToLocationMap;

    private Map<Long, Long> seedsMapping = new HashMap<>();

    public Long run() {
        DataProvider dataProvider = new InputReader();
        seeds = dataProvider.provideSeeds();
        seedToSoilMap = dataProvider.provideSeedToSoilMap();
        soilToFertilizerMap = dataProvider.provideSoilToFertilizerMap();
        fertilizerToWaterMap = dataProvider.provideFertilizerToWaterMap();
        waterToLightMap = dataProvider.provideWaterToLightMap();
        lightToTemperatureMap = dataProvider.provideLightToTemperatureMap();
        temperatureToHumidityMap = dataProvider.provideTemperatureToHumidityMap();
        humidityToLocationMap = dataProvider.provideHumidityToLocationMap();

        addSeedsToSeedsMapping();
        mapWithMapping(seedToSoilMap);
        mapWithMapping(soilToFertilizerMap);
        mapWithMapping(fertilizerToWaterMap);
        mapWithMapping(waterToLightMap);
        mapWithMapping(lightToTemperatureMap);
        mapWithMapping(temperatureToHumidityMap);
        mapWithMapping(humidityToLocationMap);

        return seedsMapping
                .values()
                .stream()
                .mapToLong(Long::longValue).min().orElseThrow(() -> new NoSuchElementException("There are no elements"));

    }

    private void addSeedsToSeedsMapping() {
        seeds.forEach((item) -> seedsMapping.put(item, item));
    }

    private void mapWithMapping(List<MapItem> currentMapping) {
        seedsMapping.replaceAll((key, value) -> mapInput(value, currentMapping));
    }

    private Long mapInput(Long input, List<MapItem> currentMapping) {
        Optional<MapItem> result =
                currentMapping
                        .stream()
                        .filter((item) -> (input >= item.getInputRangeStart() && input < (item.getInputRangeStart() + item.getRange())))
                        .findAny();

        if (result.isPresent()) {
            return result.get().mapInputToOutput(input);
        } else {
            return input;
        }
    }

}
