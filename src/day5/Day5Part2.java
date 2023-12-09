package day5;

import java.util.*;

public class Day5Part2 {

    private List<Long> seeds;
    private HashSet<Long> seedsSet;
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

        seedsSet = generateSeedsSet(seeds);

        seedToSoilMap = dataProvider.provideSeedToSoilMap();
        soilToFertilizerMap = dataProvider.provideSoilToFertilizerMap();
        fertilizerToWaterMap = dataProvider.provideFertilizerToWaterMap();
        waterToLightMap = dataProvider.provideWaterToLightMap();
        lightToTemperatureMap = dataProvider.provideLightToTemperatureMap();
        temperatureToHumidityMap = dataProvider.provideTemperatureToHumidityMap();
        humidityToLocationMap = dataProvider.provideHumidityToLocationMap();

        addSeedsToSeedsMapping();
        System.out.println("mapWithMapping(seedToSoilMap);");
        mapWithMapping(seedToSoilMap);
        System.out.println("mapWithMapping(soilToFertilizerMap);");
        mapWithMapping(soilToFertilizerMap);
        System.out.println("mapWithMapping(fertilizerToWaterMap);");
        mapWithMapping(fertilizerToWaterMap);
        System.out.println("mapWithMapping(waterToLightMap);");
        mapWithMapping(waterToLightMap);
        System.out.println("mapWithMapping(lightToTemperatureMap);");
        mapWithMapping(lightToTemperatureMap);
        System.out.println("mapWithMapping(temperatureToHumidityMap);");
        mapWithMapping(temperatureToHumidityMap);
        System.out.println("mapWithMapping(humidityToLocationMap);");
        mapWithMapping(humidityToLocationMap);

        return seedsMapping
                .values()
                .stream()
                .mapToLong(Long::longValue).min().orElseThrow(() -> new NoSuchElementException("There are no elements"));

    }

    private HashSet<Long> generateSeedsSet(List<Long> seeds) {
        HashSet<Long> result = new HashSet<>();
        for (int i = 0; i < 1; i += 2) {
            long currentInitialNumber = seeds.get(i);
            for (long j = 0; j < seeds.get(i + 1); j++) {
                result.add(currentInitialNumber + j);
            }
        }
        return result;
    }

    private void addSeedsToSeedsMapping() {
        seedsSet.forEach((item) -> seedsMapping.put(item, item));
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

