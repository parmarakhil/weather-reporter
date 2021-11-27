# weather-reporter

This application accepts data in csv format and provides terminal based UI to retrive filtered data

It provides features to 
1. getAllLocations
2. getAllReadingsByLocation
3. getAllReadingsByYear
4. getLocationWithMaxRainfall
5. getLocationWithMaxRainfallByYearAndMonth
6. getLocationWithMinRainfall
7. getLocationWithMinRainfallByYearAndMonth
8. getLocationWithMaxHoursOfSun
9. getLocationWithMaxHoursOfSunByYearAndMonth
10. getLocationWithMinHoursOfSun
11. getLocationWithMinHoursOfSunByYearAndMonth
12. getLocationWithMaxTemperature
13. getLocationWithMaxTemperatureByYearAndMonth
14. getLocationWithMinTemperature
15. getLocationWithMinTemperatureByYearAndMonth
16. getLocationsWithOldestDataOrder
17. getMaxTemperatureByLocation
18. getMinTemperatureByLocation

#### Technology used
Java

#### How to build
1. <a href="https://www.metoffice.gov.uk/research/climate/maps-and-data/historic-station-data#?tab=climateHistoric" target="blank"> Download sample data</a> in CSV format
2. Change the baseFolder inside src/main/runner/DsaProject.java to point to your data folder
3. Run the main function of src/main/runner/DsaProject.java
4. You are ready to interact using terminal UI.


