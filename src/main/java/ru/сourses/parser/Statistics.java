package ru.сourses.parser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Statistics {
    public HashMap<String, Double> osShare;
    HashSet<String> page;
    HashSet<String> missingPage;
    HashSet<String> referers;
    long totalTraffic;
    LocalDateTime maxTime;
    LocalDateTime minTime;
    HashMap<String, Integer> osCount;
    HashMap<String, Integer> browserCount;
    HashMap<String, Double> browserShare;
    HashMap<String, Double> uniqueUserVisitRate;
    HashMap<String, Integer> singleUserVisits;
    HashMap<String, Integer> mostActiveUserVisits;
    HashMap<Integer, Integer>  userVisitsPerSec;
    long userVisitsCount, uniqueUserVisitCount;
    int errorCount;
   public double errorRate, UniqueUserVisitRate, peakTrafficPerSec;

    public Statistics() {
        this.totalTraffic = 0;
        this.maxTime = null;
        this.minTime = null;
        this.page = new HashSet<>();
        this.osShare = new HashMap<>();
        this.osCount = new HashMap<>();
        this.missingPage = new HashSet<>();
        this.browserCount = new HashMap<>();
        this.browserShare = new HashMap<>();
        this.uniqueUserVisitRate  = new HashMap<>();
        this.userVisitsPerSec= new HashMap<>();
        this.singleUserVisits= new HashMap<>();
        this.mostActiveUserVisits= new HashMap<>();
        this.userVisitsCount = 0;
        this.uniqueUserVisitCount=0;
        this.errorCount = 0;
        this.errorRate = 0;
        this.peakTrafficPerSec=0;
        this.referers=new HashSet<>();
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "osShare=" + osShare +
                ", page=" + page +
                ", missingPage=" + missingPage +
                ", totalTraffic=" + totalTraffic +
                ", maxTime=" + maxTime +
                ", minTime=" + minTime +
                ", osCount=" + osCount +
                ", browserCount=" + browserCount +
                ", browserShare=" + browserShare +
                ", uniqueUserVisitRate=" + uniqueUserVisitRate +
                ", singleUserVisits=" + singleUserVisits +
                ", userVisitsCount=" + userVisitsCount +
                ", uniqueUserVisitCount=" + uniqueUserVisitCount +
                ", errorCount=" + errorCount +
                ", errorRate=" + errorRate +
                ", UniqueUserVisitRate=" + UniqueUserVisitRate +
                '}';
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

    public HashSet<String> getReferers() {
        return referers;
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
        if (logEntry.isBot == true) this.userVisitsCount = userVisitsCount + 1;

        int errorcode = logEntry.responseCode / 100;
        if (errorcode == 4 || errorcode == 5) {
            this.errorCount = this.errorCount + 1;
        }

        if (logEntry.isBot == false) {
            if (this.singleUserVisits.keySet().contains(logEntry.ipAdr)) {
                int visits = this.singleUserVisits.get(logEntry.ipAdr);
                singleUserVisits.put(logEntry.ipAdr, visits + 1);
            } else {
                singleUserVisits.put(logEntry.ipAdr, 1);
                uniqueUserVisitCount++;
            }
          int  second = logEntry.time.getSecond();
            if (userVisitsPerSec.containsKey(second)) {
                int visitsPerSec = userVisitsPerSec.get(second);
                userVisitsPerSec.put(second, visitsPerSec + 1);
            } else {
                {
                    userVisitsPerSec.put(second, 1);
                }
            }
        }
        if (logEntry.referer!="-") {referers.add(logEntry.referer);}
    }


    public double getTrafficRate() {
        double trafficRate = 0;
        long hours = ChronoUnit.HOURS.between(minTime, maxTime);
        trafficRate = (double) this.totalTraffic / hours;
        if (hours > 0) {
            trafficRate = Math.round(((double) this.totalTraffic / hours) * 100.0) / 100.0;
        }
        return trafficRate;

    }
    public HashMap<String, Double> getBrowserShare() {
        int total = 0;
        for (int count : this.browserCount.values()) {
            total += count;
        }
        for (Entry<String, Integer> entry : this.browserCount.entrySet()) {
            String browser = entry.getKey();
            int q = entry.getValue();
            double share = (double) q / total;
            this.browserShare.put(browser, share);
        }
        return browserShare;
    }
    public HashMap<String, Double> getOsShare() {
        int total = 0;
        for (int count : this.osCount.values()) {
            total += count;
        }
        for (Entry<String, Integer> entry : this.osCount.entrySet()) {
            String os = entry.getKey();
            int q = entry.getValue();
            double share = (double) q / total;
            this.osShare.put(os, share);
        }
        return osShare;
    }
    public HashSet<String> getMissingPage() {
        return missingPage;
    }
    public double getUserVisitRate() {
        double userVisitRate = 0;
        long hours = ChronoUnit.HOURS.between(minTime, maxTime);
        userVisitRate = (double) this.userVisitsCount / hours;

        return userVisitRate;
    }
    public double getErrorRate(){
               long hours = ChronoUnit.HOURS.between(minTime, maxTime);
        this.errorRate = (double) this.errorCount / hours;
        return this.errorRate;
    }
    public HashMap<String, Double> getUniqueUserVisitRate() {
        if (uniqueUserVisitCount > 0) {
            uniqueUserVisitRate = singleUserVisits.
                    entrySet().
                    stream().
                    collect(Collectors.toMap(Entry::getKey,
                            entry -> Math.round((double) entry.getValue() / uniqueUserVisitCount * 10000.0) / 10000.0,
                            (existing, replacement) -> existing, // на случай конфликтов
                    HashMap::new));
        }
        return uniqueUserVisitRate;

    }

    public Optional<Entry<Integer, Integer>> getPeakTrafficPerSec(){
        Optional<Entry<Integer, Integer>> peakEntry =  userVisitsPerSec.
                entrySet()
                .stream()
                .sorted(Entry.<Integer, Integer>comparingByValue().reversed())
                .findFirst();

        return peakEntry;
    }
public Optional<Entry<String, Integer>> getmostActiveUserVisits(){
        Optional<Entry<String, Integer>> mostActiveUserVisits= singleUserVisits
                .entrySet()
                .stream()
                .sorted(Entry.<String, Integer>comparingByValue().reversed())
                .findFirst();

        return mostActiveUserVisits;
    }

}



