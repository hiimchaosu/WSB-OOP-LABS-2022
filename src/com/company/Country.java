package com.company;

public enum Country {
    POLAND("Polish","PL",4252356.0), VIETNAM("VIETNAMESE", "VN",1234568.0),
    NORWAY("Norwegian","NO", 9999999999.0), ENGLAND("English", "UK",4515423464.0),
    ISLEOFMAN("Manx", "IM",6347865.0);

    private String language;
    private String code;
    private double gdpInUsd;
    Country(String language, String code, double gdpInUsd) {
        this.language = language;
        this.code = code;
        this.gdpInUsd = gdpInUsd;
    }

    public String getLanguage() {
        return language;
    }

    public String getCode() {
        return code;
    }

    public double getGdpInUsd() {
        return gdpInUsd;
    }

    public double getGdpInPln(){
        return this.getGdpInUsd()*4.00;
    }
}

