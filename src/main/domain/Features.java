package main.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Features {

    private final Map<String,List<Reading>> locationData;

    public  Features(Map<String,List<Reading>> locationData){
        this.locationData=locationData;
    }


    /*
     * @Returns list of all locations for which data is available
     */
    public Set<String> getAllLocations() {
        return this.locationData.keySet();
    }


    /*
     * @Returns all data for a given location in chronological order
     */
    public  List<Reading> getAllReadingsByLocation(String cityName) {
        List<Reading> readings = locationData.get(cityName.toLowerCase());
        if (readings !=null && !readings.isEmpty()) {
            List<Reading> list = new ArrayList<Reading>(readings);
            Comparator<Reading> cmp = Comparator.comparing(Reading::getYear)
                    .thenComparing(Reading::getMonth);
            Collections.sort(list, cmp);
            return  list;
        }
        return null;
    }



    /*
     * @Returns data for a given year across all locations
     */
    public List<Reading> getAllReadingsByYear(Integer year) {
        List<Reading> readings = new ArrayList<>();
        for (List<Reading> localData : locationData.values()) {
            readings.addAll(localData.stream().filter(reading -> reading.getYear().equals(year)).collect(Collectors.toList()));
        }
        return readings;
    }


    /*
     * @Returns location with Max rainfall
     */
    public String getLocationWithMaxRainfall() {
        Double maxRainFall= Double.MIN_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading maxReading = cityWeather.getValue().stream().max(Comparator.comparing(Reading::getRainInMM)).orElse(null);
            if(maxReading!=null){
                maxRainFall = Math.max(maxReading.getRainInMM(),maxRainFall);
                if(maxRainFall.equals(maxReading.getRainInMM())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }


    /*
     * @Returns location with Max rainfall by year & month
     */
    public String getLocationWithMaxRainfallByYearAndMonth(Integer year, Integer month) {
        Double maxRainFall= Double.MIN_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading maxReading = cityWeather.getValue().stream().filter(reading -> year.equals(reading.getYear()))
                    .filter(reading -> month.equals(reading.getMonth())).max(Comparator.comparing(Reading::getRainInMM)).orElse(null);
            if(maxReading!=null){
                maxRainFall = Math.max(maxReading.getRainInMM(),maxRainFall);
                if(maxRainFall.equals(maxReading.getRainInMM())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Min rainfall
     */
    public String getLocationWithMinRainfall() {
        Double minRainFall= Double.MAX_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().min(Comparator.comparing(Reading::getRainInMM)).orElse(null);
            if(minReading!=null){
                minRainFall = Math.min(minReading.getRainInMM(),minRainFall);
                if(minRainFall.equals(minReading.getRainInMM())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Min rainfall
     */
    public String getLocationWithMinRainfallByYearAndMonth(Integer year, Integer month) {
        Double minRainFall= Double.MAX_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().filter(reading -> year.equals(reading.getYear()))
                    .filter(reading -> month.equals(reading.getMonth())).min(Comparator.comparing(Reading::getRainInMM)).orElse(null);
            if(minReading!=null){
                minRainFall = Math.min(minReading.getRainInMM(),minRainFall);
                if(minRainFall.equals(minReading.getRainInMM())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Max hours of sun
     */
    public String getLocationWithMaxHoursOfSun() {
        Double maxHoursOfSun= Double.MIN_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading maxReading = cityWeather.getValue().stream().max(Comparator.comparing(Reading::getHoursOfSun)).orElse(null);
            if(maxReading!=null){
                maxHoursOfSun = Math.max(maxReading.getHoursOfSun(),maxHoursOfSun);
                if(maxHoursOfSun.equals(maxReading.getHoursOfSun())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Max hours of sun
     */
    public String getLocationWithMaxHoursOfSunByYearAndMonth(Integer year, Integer month) {
        Double maxHoursOfSun= Double.MIN_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading maxReading = cityWeather.getValue().stream().filter(reading -> year.equals(reading.getYear()))
                    .filter(reading -> month.equals(reading.getMonth())).max(Comparator.comparing(Reading::getHoursOfSun)).orElse(null);
            if(maxReading!=null){
                maxHoursOfSun = Math.max(maxReading.getHoursOfSun(),maxHoursOfSun);
                if(maxHoursOfSun.equals(maxReading.getHoursOfSun())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Min hours of sun
     */
    public String getLocationWithMinHoursOfSun() {
        Double minHoursOfSun= Double.MAX_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().min(Comparator.comparing(Reading::getHoursOfSun)).orElse(null);
            if(minReading!=null){
                minHoursOfSun = Math.min(minReading.getHoursOfSun(),minHoursOfSun);
                if(minHoursOfSun.equals(minReading.getHoursOfSun())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Min hours of sun
     */
    public String getLocationWithMinHoursOfSunByYearAndMonth(Integer year, Integer month) {
        Double minHoursOfSun= Double.MAX_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().filter(reading -> year.equals(reading.getYear()))
                    .filter(reading -> month.equals(reading.getMonth())).min(Comparator.comparing(Reading::getHoursOfSun)).orElse(null);
            if(minReading!=null){
                minHoursOfSun = Math.min(minReading.getHoursOfSun(),minHoursOfSun);
                if(minHoursOfSun.equals(minReading.getHoursOfSun())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Max temperature
     */
    public String getLocationWithMaxTemperature() {
        Double maxTemperature= Double.MIN_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading maxReading = cityWeather.getValue().stream().max(Comparator.comparing(Reading::getMaxTemperature)).orElse(null);
            if(maxReading!=null){
                maxTemperature = Math.max(maxReading.getMaxTemperature(),maxTemperature);
                if(maxTemperature.equals(maxReading.getMaxTemperature())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Max temperature
     */
    public String getLocationWithMaxTemperatureByYearAndMonth(Integer year, Integer month) {
        Double maxTemperature= Double.MIN_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading maxReading = cityWeather.getValue().stream().filter(reading -> year.equals(reading.getYear()))
                    .filter(reading -> month.equals(reading.getMonth())).max(Comparator.comparing(Reading::getMaxTemperature)).orElse(null);
            if(maxReading!=null){
                maxTemperature = Math.max(maxReading.getMaxTemperature(),maxTemperature);
                if(maxTemperature.equals(maxReading.getMaxTemperature())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }


    /*
     * @Returns location with Min temperature
     */
    public String getLocationWithMinTemperature() {
        Double minTemperature= Double.MAX_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().min(Comparator.comparing(Reading::getMinTemperature)).orElse(null);
            if(minReading!=null){
                minTemperature = Math.min(minReading.getMinTemperature(),minTemperature);
                if(minTemperature.equals(minReading.getMinTemperature())){
                    location=cityWeather.getKey();
                }
            }

        }
        return location;
    }

    /*
     * @Returns location with Min temperature
     */
    public String getLocationWithMinTemperatureByYearAndMonth(Integer year, Integer month) {
        Double minTemperature= Double.MAX_VALUE;
        String location = "";
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().filter(reading -> year.equals(reading.getYear()))
                    .filter(reading -> month.equals(reading.getMonth())).min(Comparator.comparing(Reading::getMinTemperature)).orElse(null);
            if(minReading!=null){
                minTemperature = Math.min(minReading.getMinTemperature(),minTemperature);
                if(minTemperature.equals(minReading.getMinTemperature())){
                    location=cityWeather.getKey();
                }
            }
        }
        return location;
    }

    /*
     * @Returns all locations in oldest first order
     */
    public Set<String> getLocationsWithOldestDataOrder() {
        Map<String ,Reading> oldReadings=new LinkedHashMap<>();
        for (Map.Entry<String, List<Reading>> cityWeather:locationData.entrySet()){
            Reading minReading = cityWeather.getValue().stream().min(Comparator.comparing(Reading::getYear)).orElse(null);
            if(minReading!=null){
                oldReadings.put(cityWeather.getKey(),minReading);
            }
        }
       oldReadings = oldReadings.entrySet().stream()
                .sorted((k1, k2) -> k1.getValue().getYear().compareTo(k2.getValue().getYear()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
       return oldReadings.keySet();

    }

    /*
     * @Returns Max temperature Reading for a given location
     */
    public Reading getMaxTemperatureByLocation(String location) {
        List<Reading> readings = locationData.get(location.toLowerCase());
        if(readings !=null && !readings.isEmpty()){
            return readings.stream().max(Comparator.comparing(Reading::getMaxTemperature)).get();
        }
        return null;
    }

    /*
     * @Returns Min temperature Reading for a given location
     */
    public Reading getMinTemperatureByLocation(String location) {
        List<Reading> readings = locationData.get(location.toLowerCase());
        if(readings !=null && !readings.isEmpty()){
            return readings.stream().min(Comparator.comparing(Reading::getMinTemperature)).get();
        }
        return null;
    }


}
