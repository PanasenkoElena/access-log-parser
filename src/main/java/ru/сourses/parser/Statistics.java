package ru.сourses.parser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {
    long totalTraffic;
    LocalDateTime maxTime;
    LocalDateTime minTime;
    public HashSet<String> page;
    HashMap<String, Integer> osCount;
    public HashMap<String, Double> osShare;
    public HashSet <String> missingPage;
    HashMap<String, Integer> browserCount;
    HashMap<String, Double> browserShare;


    @Override
    public String toString() {
        return "Statistics{" +
                "totalTraffic=" + totalTraffic +
                ", maxTime=" + maxTime +
                ", minTime=" + minTime +
                ", page=" + page +
                ", osCount=" + osCount +
                ", osShare=" + osShare +
                '}';
    }

    public Statistics() {
        this.totalTraffic = 0;
        this.maxTime =null;
        this.minTime = null;
        this.page = new HashSet<>();
        this.osShare=new HashMap<>();
        this.osCount=new HashMap<>();
        this.missingPage = new HashSet<>();
        this.browserCount=new HashMap<>();
        this.browserShare=new HashMap<>();
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
            if (logEntry.time.isBefore(minTime)) {
                setMinTime(logEntry.time);
            }
            if (logEntry.time.isAfter(maxTime)) {
                setMaxTime(logEntry.time);
            }
        }
        if (logEntry.path != null && logEntry.responseCode == 200) {
            page.add(logEntry.path);
        }
        if (logEntry.userAgent.os != null) {
            if (osCount.keySet().contains(logEntry.userAgent.os)) {
                int count = this.osCount.get(logEntry.userAgent.os);
                this.osCount.put(logEntry.userAgent.os, count + 1);
            } else {
                this.osCount.put(logEntry.userAgent.os, 1);
            }
        }
        if (logEntry.userAgent.browser != null) {
            if (browserCount.keySet().contains(logEntry.userAgent.browser)) {
                int count = this.browserCount.get(logEntry.userAgent.browser);
                this.browserCount.put(logEntry.userAgent.browser, count + 1);
            } else {
                this.browserCount.put(logEntry.userAgent.browser, 1);
            }
        }
        if (logEntry.responseCode == 404) {
            missingPage.add(logEntry.path);
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
    public HashMap<String, Double> getBrowserShare(){
        int total = 0;
        for (int count : this.browserCount.values()) {
            total += count;}
        for (Map.Entry<String, Integer> entry : this.browserCount.entrySet()) {
            String browser= entry.getKey();
            int q= entry.getValue();
            double share = (double) q / total;
            this.browserShare.put(browser, share); }
        return browserShare;}

    public HashMap<String, Double> getOsShare(){
        int total = 0;
        for (int count : this.osCount.values()) {
            total += count;}
        for (Map.Entry<String, Integer> entry : this.osCount.entrySet()) {
           String os= entry.getKey();
           int q= entry.getValue();
            double share = (double) q / total;
            this.osShare.put(os, share); }
        return osShare;}

    public HashSet<String> getMissingPage() {
        return missingPage;
    }
}

