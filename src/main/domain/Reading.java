package main.domain;

public class Reading {
    private Integer year = 0;
    private Integer month = 0;
    private Double maxTemperature = 0.0 ;
    private Double minTemperature = 0.0 ;
    private Integer frostyDays = 0 ;
    private Double rainInMM = 0.0;
    private Double hoursOfSun = 0.0 ;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getFrostyDays() {
        return frostyDays;
    }

    public void setFrostyDays(Integer frostyDays) {
        this.frostyDays = frostyDays;
    }

    public Double getRainInMM() {
        return rainInMM;
    }

    public void setRainInMM(Double rainInMM) {
        this.rainInMM = rainInMM;
    }

    public Double getHoursOfSun() {
        return hoursOfSun;
    }

    public void setHoursOfSun(Double hoursOfSun) {
        this.hoursOfSun = hoursOfSun;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "year=" + year +
                ", month=" + month +
                ", maxTemperature=" + maxTemperature +
                ", minTemperature=" + minTemperature +
                ", frostyDays=" + frostyDays +
                ", rainInMM=" + rainInMM +
                ", hoursOfSun=" + hoursOfSun +
                '}';
    }
}
