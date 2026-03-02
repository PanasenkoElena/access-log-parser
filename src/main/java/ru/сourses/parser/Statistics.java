package ru.сourses.parser;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Statistics {
    long totalTraffic;
    LocalDateTime maxTime;
    LocalDateTime minTime;


    public Statistics() {
        this.totalTraffic = 0;
        this.maxTime =null;
        this.minTime = null;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalDateTime maxTime) {
        this.maxTime = maxTime;
    }

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalDateTime minTime) {
        this.minTime = minTime;
    }

    public void addEntry(LogEntry logEntry) {
        this.totalTraffic += logEntry.responseSize;
        if (minTime == null && maxTime == null) {
            setMinTime(logEntry.time);
            setMaxTime(logEntry.time);

        } else {
            if (logEntry.time.isBefore(minTime)) { setMinTime(logEntry.time);}
            if (logEntry.time.isAfter(maxTime)) {setMaxTime(logEntry.time);}
            }
        }


    public double getTrafficRate() {
        double trafficRate =0;
        long hours = ChronoUnit.HOURS.between(minTime, maxTime);
        trafficRate = (double) this.totalTraffic / hours;
        if (hours > 0) {
        trafficRate = Math.round(((double) this.totalTraffic / hours)* 100.0) / 100.0;}
        return trafficRate;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "totalTraffic=" + totalTraffic +
                ", maxTime=" + maxTime +
                ", minTime=" + minTime +
                '}';
    }}

