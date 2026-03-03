package ru.сourses.parser;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.util.stream.IntStream.range;

public class LogEntry {
    final LocalDateTime time;
    final HttpMethod method;
    final String ipAdr, path, referer;
    final int responseSize, responseCode;
    final UserAgent userAgent;

    public LogEntry(String line) {
        this.time = takeTime(line);
        this.method = takeMethod(line);
        this.ipAdr = takeIpAdr(line);
        this.path = takePath(line);
        this.responseCode = takeCode(line);
        this.responseSize = takeResponseSize(line);
        this.referer = takeReferer(line);

        int lastQuote = line.lastIndexOf("\"");
        int prevQuote = line.lastIndexOf("\"", lastQuote - 1);
        if (lastQuote - prevQuote < 2) {
            this.userAgent = new UserAgent();
        } else {
            if (lastQuote != -1 && prevQuote != -1) {
                String str = line.substring(prevQuote + 1, lastQuote);
                this.userAgent = new UserAgent(str);
            } else {this.userAgent = new UserAgent();}
        }

    }

    public LocalDateTime getTime() {
        return time;
    }
    public HttpMethod getMethod() {
        return method;
    }
    public String getIpAdr() {
        return ipAdr;
    }
    public String getPath() {
        return path;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public int getResponseSize() {
        return responseSize;
    }
    public String getReferer() {
        return referer;
    }
    public UserAgent getUserAgent() {
        return userAgent;
    }

    private LocalDateTime takeTime(String line) {
        LocalDateTime time=null;
        try {
            int start = line.indexOf('[');
            int end = line.indexOf(']');
            if (start != -1 && end != -1 && end > start) {
                String draftTime = line.substring(start + 1, end);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
                time = LocalDateTime.parse(draftTime, formatter);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return time;
    }
    private HttpMethod takeMethod(String line) {
        HttpMethod draftMethod = null;
        try {
            int start = line.indexOf("]");
            int end = line.indexOf("/", start + 1);
            if (start != -1 && end != -1 && end > start) {
                String stringMethod = line.substring(start + 3, end);
                draftMethod = HttpMethod.valueOf(stringMethod.replaceAll("[ /:+]", ""));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return draftMethod;
    }
    private String takeIpAdr(String line){
        String ipAdr="";
        try {
            int start = 0;
            int end = line.indexOf(" ", start + 1);
            if (end != -1 && end > start) {
                ipAdr= line.substring(start, end);
                ipAdr = ipAdr.replaceAll("[ /:+]", "");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ipAdr;
    }
    private String takePath(String line){
       String path="";
       try {
            int start = line.indexOf("/", line.indexOf("\"")+1);
            int end = line.indexOf(" ", start + 1);
            if (end != -1 && end > start) {
                path= line.substring(start, end+1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return path;
    }
    private int takeCode(String line){
        int code=0;
        try {
            int start = line.indexOf("\"", line.indexOf("\"")+1)+1;
            int end = start + 3;
            if (start != -1 && end > start) {
                code= Integer.parseInt(line.substring(start+1, end+1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return code;
    }
    private int takeResponseSize(String line){
        int size=0;
        try {
            int start = range(0, line.length()).filter(i -> line.charAt(i) ==' ').toArray()[8];
            int end= range(0, line.length()).filter(i -> line.charAt(i) == ' ').toArray()[9];
            size=Integer.parseInt(line.substring(start+1, end));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return size;
    }
    private String takeReferer(String line){
       String referer="-";
        try {
            int start = range(0, line.length()).filter(i -> line.charAt(i) =='"').toArray()[2];
            int end= range(0, line.length()).filter(i -> line.charAt(i) == '"').toArray()[3];
            referer=line.substring(start+1, end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return referer;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "time=" + time +
                ", method=" + method +
                ", ipAdr='" + ipAdr + '\'' +
                ", path='" + path + '\'' +
                ", referer='" + referer + '\'' +
                ", responseSize=" + responseSize +
                ", responseCode=" + responseCode +
                ", userAgent=" + userAgent +
                '}';
    }
}
