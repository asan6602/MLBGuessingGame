package com.example;

public class battingEntry {

    private String year;
    private String team;
    private String g;
    private String ab;
    private String r;
    private String h;
    private String _2b;
    private String _3b;
    private String hr;
    private String rbi;
    private String bb;
    private String sb;

    

    public battingEntry(String year, String team, String g, String ab, String r, String h, String _2b, String _3b,
            String hr, String rbi, String bb, String sb) {
        this.year = year;
        this.team = team;
        this.g = g;
        this.ab = ab;
        this.r = r;
        this.h = h;
        this._2b = _2b;
        this._3b = _3b;
        this.hr = hr;
        this.rbi = rbi;
        this.bb = bb;
        this.sb = sb;

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



    public String getAb() {
        return ab;
    }



    public String getR() {
        return r;
    }



    public String getH() {
        return h;
    }



    public String get_2b() {
        return _2b;
    }



    public String get_3b() {
        return _3b;
    }



    public String getHr() {
        return hr;
    }



    public String getRbi() {
        return rbi;
    }



    public String getBb() {
        return bb;
    }



    public String getSb() {
        return sb;
    }

    
    
    
}
