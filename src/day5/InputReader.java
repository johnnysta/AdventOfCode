package day5;

import util.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputReader implements DataProvider {


    private final List<Long> seeds;
    private final List<MapItem> seedToSoilMap = new ArrayList<>();
    private final List<MapItem> soilToFertilizerMap = new ArrayList<>();
    private final List<MapItem> fertilizerToWaterMap = new ArrayList<>();
    private final List<MapItem> waterToLightMap = new ArrayList<>();
    private final List<MapItem> lightToTemperatureMap = new ArrayList<>();
    private final List<MapItem> temperatureToHumidityMap = new ArrayList<>();
    private final List<MapItem> humidityToLocationMap = new ArrayList<>();

    @Override
    public List<Long> provideSeeds() {
        return seeds;
    }

    @Override
    public List<MapItem> provideSeedToSoilMap() {
        return seedToSoilMap;
    }

    @Override
    public List<MapItem> provideSoilToFertilizerMap() {
        return soilToFertilizerMap;
    }

    @Override
    public List<MapItem> provideFertilizerToWaterMap() {
        return fertilizerToWaterMap;
    }

    @Override
    public List<MapItem> provideWaterToLightMap() {
        return waterToLightMap;
    }

    @Override
    public List<MapItem> provideLightToTemperatureMap() {
        return lightToTemperatureMap;
    }

    @Override
    public List<MapItem> provideTemperatureToHumidityMap() {
        return temperatureToHumidityMap;
    }

    @Override
    public List<MapItem> provideHumidityToLocationMap() {
        return humidityToLocationMap;
    }


    public InputReader() {
        List<String> inputLines = FileReader.readInputFile("resources/Day5/input.txt");
        inputLines.add("");
        seeds = parseSeeds(inputLines);
        parseMap("seed-to-soil map:", inputLines, seedToSoilMap);
        parseMap("soil-to-fertilizer map:", inputLines, soilToFertilizerMap);
        parseMap("fertilizer-to-water map:", inputLines, fertilizerToWaterMap);
        parseMap("water-to-light map:", inputLines, waterToLightMap);
        parseMap("light-to-temperature map:", inputLines, lightToTemperatureMap);
        parseMap("temperature-to-humidity map:", inputLines, temperatureToHumidityMap);
        parseMap("humidity-to-location map:", inputLines, humidityToLocationMap);

    }

    private List<Long> parseSeeds(List<String> inputLines) {
        String firstLine = inputLines.get(0);
        String numbersSubString = firstLine.substring(firstLine.indexOf(':') + 1);
        String[] array = numbersSubString.trim().split("\s+");
        return Arrays.stream(array).map(Long::parseLong).toList();
    }

    private void parseMap(String mapName, List<String> inputLines, List<MapItem> currentMapping) {
        int i = 0;
        while (!mapName.equals(inputLines.get(i))) {
            i++;
        }
        i++;
        String currentLine = inputLines.get(i);
        while (!currentLine.equals("")) {
            MapItem mapItem = parseCurrentLine(currentLine);
            currentMapping.add(mapItem);
            i++;
            currentLine = inputLines.get(i);
        }
    }

    private MapItem parseCurrentLine(String currentLine) {
        String[] actualNumStrings = currentLine.trim().split("\s+");
        MapItem mapItem = new MapItem(Long.parseLong(actualNumStrings[0]),
                Long.parseLong(actualNumStrings[1]),
                Long.parseLong(actualNumStrings[2]));
        return mapItem;
    }

}
