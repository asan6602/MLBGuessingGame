package com.example;

public class pitchingEntry {
    private String year;
    private String team;
    private String g;
    private String w;
    private String l;
    private String sv;
    private String so;
    private String era;
    private String ip;

    public pitchingEntry(String year, String team, String g, String w, String l, String sv, String so, String era,
            String ip) {
        this.year = year;
        this.team = team;
        this.g = g;
        this.w = w;
        this.l = l;
        this.sv = sv;
        this.so = so;
        this.era = era;

        int Innings = Integer.parseInt(ip) / 3;
        this.ip = Integer.toString(Innings);
    }

    public String getYear() {
        return year;
    }

    public String getTeam() {
        return team;
    }

    public String getG() {
        return g;
    }

    public String getW() {
        return w;
    }

    public String getL() {
        return l;
    }

    public String getSv() {
        return sv;
    }

    public String getSo() {
        return so;
    }

    public String getEra() {
        return era;
    }

    public String getIp() {
        return ip;
    }

    

    
}
