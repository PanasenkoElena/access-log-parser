package ru.сourses.parser;

public class UserAgent {
final String browser;
final String os;

    public UserAgent(String str) {
        this.browser =takeBrowser(str);
        this.os = takeOs(str);
    }

    public UserAgent() {
        this.browser = null;
        this.os = null;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOs() {
        return os;
    }


    private String takeBrowser(String str) throws NullPointerException {
     try {
         if (str.contains("OPR/") || str.contains("Opera/")) return "Opera";
        if (str.contains("Firefox/")) return "Firefox";
        if (str.contains("Edge/")) return "Edge";
        if (str.contains("Chrome/")) return "Chrome";
        if (str.contains("Safari/")) return "Safari";
        return "Other Browser";}
     catch (Exception e) {
         throw new RuntimeException(e);
     }
        }


    private String takeOs (String str){
        try { if (str.contains("Windows")) return "Windows";
        if (str.contains("Macintosh")) return "macOS";
        if (str.contains("Linux")) return "Linux";
        return "Other OS";}
         catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "os='" + os + '\'' +
                ", browser='" + browser + '\'' +
                '}';
    }
}
