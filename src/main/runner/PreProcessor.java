package main.runner;

import com.opencsv.CSVReader;
import main.domain.Reading;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class PreProcessor {
    private static String BASE_FOLDER;
    public static Map<String,List<Reading>> preProcess(String baseFolder){
        Map<String,List<Reading>> locationData=new HashMap<>();

        BASE_FOLDER=baseFolder;
        loadData(locationData);
        return  locationData;
    }

    private static void loadData(Map<String,List<Reading>> locationData) {
        File allDataFiles = new File(BASE_FOLDER);

        for (File singleFile : allDataFiles.listFiles()) {
            System.out.println(singleFile.getAbsolutePath());
            parseFile(singleFile.getAbsolutePath(), locationData);
            System.out.println("---------------------------------------------------------------------------------------");
        }
//        cityWeathers.forEach(e -> System.out.println(e.getLocation()));

    }

    private static void parseFile(String filePath, Map<String,List<Reading>> locationData) {
        if(filePath.isEmpty()) return;
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filePath));
            String location = new File(filePath).getName().split("\\.")[0].split("data")[0];
            List<Reading> readings = new ArrayList<>();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String record : nextLine) {
                    record = record.trim();
                    if (!record.isEmpty() && Character.isDigit(record.charAt(0))) {
                        record = record.trim().replaceAll(" +", " ");
                        String[] recordData = record.split(" ");
                        if(recordData.length>=6) {
                            Reading reading = new Reading();
                            try {
                                reading.setYear(Integer.parseInt(recordData[0]));
                            } catch (Exception e) {
                                System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[0]);
                            }
                            try {
                                reading.setMonth(Integer.parseInt(recordData[1]));
                            } catch (Exception e) {
                                System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[1]);
                            }
                            try {
                                reading.setMaxTemperature(Double.parseDouble(recordData[2]));
                            } catch (Exception e) {
                                if(recordData[2].endsWith("*")){
                                    reading.setMaxTemperature(Double.parseDouble(recordData[2].substring(0,recordData[2].length()-1)));
                                }else
                                    System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[2]);
                            }
                            try {
                                reading.setMinTemperature(Double.parseDouble(recordData[3]));
                            } catch (Exception e) {
                                if(recordData[3].endsWith("*")){
                                    reading.setMinTemperature(Double.parseDouble(recordData[3].substring(0,recordData[3].length()-1)));
                                }else
                                    System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[3]);
                            }
                            try {
                                reading.setFrostyDays(Integer.parseInt(recordData[4]));
                            } catch (Exception e) {
                                if(recordData[4].endsWith("*")){
                                    reading.setFrostyDays(Integer.parseInt(recordData[4].substring(0,recordData[4].length()-1)));
                                }else
                                    System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[4]);
                            }
                            try {
                                reading.setRainInMM(Double.parseDouble(recordData[5]));
                            } catch (Exception e) {
                                if(recordData[5].endsWith("*")){
                                    reading.setRainInMM(Double.parseDouble(recordData[5].substring(0,recordData[5].length()-1)));
                                }else
                                    System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[5]);
                            }
                            try {
                                reading.setHoursOfSun(Double.parseDouble(recordData[6]));
                            } catch (Exception e) {
                                if(recordData[6].endsWith("*")){
                                    reading.setHoursOfSun(Double.parseDouble(recordData[6].substring(0,recordData[6].length()-1)));
                                }else
                                    System.out.println("Exception occured while parsing " + location + " " + record + " " + recordData[6]);
                            }
                            readings.add(reading);
                        }
                    }
                }
            }
            locationData.put(location,readings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
