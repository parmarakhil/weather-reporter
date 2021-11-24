package main.runner;

import main.domain.Reading;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DsaProject {

    private static final String baseFolder = "/SampleData";

    public static void main(String[] args) {
        Map<String, List<Reading>> cityWeathers = PreProcessor.preProcess(baseFolder);
        Features features = new Features(cityWeathers);
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ! Please select any of the available option \n" +
                "1. To view all available locations \n" +
                "2. To view all readings for a location \n" +
                "3. To view all readings for a year \n" +
                "4. To view max temperature for a location \n" +
                "5. To view min temperature for a location \n " +
                "6. To view location with max rainfall \n" +
                "7. To view location with min rainfall \n" +
                "8. To view location with max hours of sun \n" +
                "9. To view location with min hours of sun \n" +
                "10. To view location with max temperature \n" +
                "11. To view location with min temperature \n" +
                "12. To view location with max rainfall for a month & year \n" +
                "13. To view location with min rainfall for a month & year \n" +
                "14. To view location with max hours of sun for a month & year \n" +
                "15. To view location with min hours of sun for a month & year \n" +
                "16. To view location with max temperature for a month & year \n" +
                "17. To view location with min temperature for a month & year \n" +
                "18. To view locations in order of their earliest data available \n\n" +
                "You can enter any other key (Except number) to exit");
        while (flag) {
            try {
                Integer input = Integer.parseInt(scanner.nextLine());
                processInput(input, features, scanner);
                System.out.println("\n Enter next option");
            } catch (Exception e) {
                System.out.println("Invalid input. Exiting the program");
                flag = false;
            }
        }
    }


    private static void processInput(Integer input, Features features, Scanner scanner) {
        switch (input) {
            case 1:
                features.getAllLocations();
                Set<String> allLocations = features.getAllLocations();
                if (allLocations != null && !allLocations.isEmpty())
                    allLocations.forEach(location -> System.out.println(location));
                else
                    System.out.println("No data avaialable");
                break;
            case 2:
                System.out.println("Please enter location Name");
                String location = scanner.nextLine().trim();
                List<Reading> readingsByLocation = features.getAllReadingsByLocation(location);
                if (readingsByLocation != null && !readingsByLocation.isEmpty()) {
                    readingsByLocation.forEach(reading -> System.out.printf(reading.toString() + "\n"));
                } else {
                    System.out.println("No reading available for location " + location);
                }
                break;
            case 3:
                System.out.println("Please enter the year");
                try {
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null) {
                        List<Reading> readingsByYear = features.getAllReadingsByYear(year);
                        if (readingsByYear != null) {
                            readingsByYear.forEach(reading -> System.out.println(reading));
                        } else {
                            System.out.println("No reading available for year " + year);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 4:
                System.out.println("Please enter location Name");
                String maxLocation = scanner.nextLine().trim();
                Reading readingByMaxTemperature = features.getMaxTemperatureByLocation(maxLocation);
                if (readingByMaxTemperature != null) {
                    System.out.println(readingByMaxTemperature);
                } else {
                    System.out.println("No reading available for location " + maxLocation);
                }
                break;
            case 5:
                System.out.println("Please enter location Name");
                String minLocation = scanner.nextLine().trim();
                Reading readingByMinTemperature = features.getMinTemperatureByLocation(minLocation);
                if (readingByMinTemperature != null) {
                    System.out.println(readingByMinTemperature);
                } else {
                    System.out.println("No reading available for location " + minLocation);
                }
                break;
            case 6:
                System.out.println(features.getLocationWithMaxRainfall());
                break;
            case 7:
                System.out.println(features.getLocationWithMinRainfall());
                break;
            case 8:
                System.out.println(features.getLocationWithMaxHoursOfSun());
                break;
            case 9:
                System.out.println(features.getLocationWithMinHoursOfSun());
                break;
            case 10:
                System.out.println(features.getLocationWithMinTemperature());
                break;
            case 11:
                System.out.println(features.getLocationWithMaxTemperature());
                break;
            case 12:
                try {
                    System.out.println("Please enter the year");
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Please enter the month");
                    Integer month = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null && month != null) {
                        String maxRain = features.getLocationWithMaxRainfallByYearAndMonth(year, month);
                        if (maxRain != null && !maxRain.isBlank() && !maxRain.isEmpty()) {
                            System.out.println(maxRain);
                        } else {
                            System.out.println("No reading available for year " + year + " & month " + month);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 13:
                try {
                    System.out.println("Please enter the year");
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Please enter the month");
                    Integer month = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null && month != null) {
                        String minRain = features.getLocationWithMinRainfallByYearAndMonth(year, month);
                        if (minRain != null && !minRain.isBlank() && !minRain.isEmpty()) {
                            System.out.println(minRain);
                        } else {
                            System.out.println("No reading available for year " + year + " & month " + month);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 14:
                try {
                    System.out.println("Please enter the year");
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Please enter the month");
                    Integer month = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null && month != null) {
                        String maxHrsOfSun = features.getLocationWithMaxHoursOfSunByYearAndMonth(year, month);
                        if (maxHrsOfSun != null && !maxHrsOfSun.isBlank() && !maxHrsOfSun.isEmpty()) {
                            System.out.println(maxHrsOfSun);
                        } else {
                            System.out.println("No reading available for year " + year + " & month " + month);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 15:
                try {
                    System.out.println("Please enter the year");
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Please enter the month");
                    Integer month = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null && month != null) {
                        String minHrsOfSun = features.getLocationWithMinHoursOfSunByYearAndMonth(year, month);
                        if (minHrsOfSun != null && !minHrsOfSun.isBlank() && !minHrsOfSun.isEmpty()) {
                            System.out.println(minHrsOfSun);
                        } else {
                            System.out.println("No reading available for year " + year + " & month " + month);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 16:
                try {
                    System.out.println("Please enter the year");
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Please enter the month");
                    Integer month = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null && month != null) {
                        String maxTemperature = features.getLocationWithMaxTemperatureByYearAndMonth(year, month);
                        if (maxTemperature != null && !maxTemperature.isBlank() && !maxTemperature.isEmpty()) {
                            System.out.println(maxTemperature);
                        } else {
                            System.out.println("No reading available for year " + year + " & month " + month);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 17:
                try {
                    System.out.println("Please enter the year");
                    Integer year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Please enter the month");
                    Integer month = Integer.parseInt(scanner.nextLine().trim());
                    if (year != null && month != null) {
                        String minTemperature = features.getLocationWithMinTemperatureByYearAndMonth(year, month);
                        if (minTemperature != null && !minTemperature.isBlank() && !minTemperature.isEmpty()) {
                            System.out.println(minTemperature);
                        } else {
                            System.out.println("No reading available for year " + year + " & month " + month);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again");
                }
                break;
            case 18:
                Set<String> allLocationsSorted = features.getLocationsWithOldestDataOrder();
                if (allLocationsSorted != null && !allLocationsSorted.isEmpty())
                    allLocationsSorted.forEach(allLocation -> System.out.println(allLocation));
                else
                    System.out.println("No data avaialable");
                break;

            default:
                System.out.println("Can't find an available option. Please try again");
                break;
        }

    }


}
