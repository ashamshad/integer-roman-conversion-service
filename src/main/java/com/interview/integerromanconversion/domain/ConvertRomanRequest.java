package com.interview.integerromanconversion.domain;

public class ConvertRomanRequest {
    private String roman;

    public ConvertRomanRequest() {}

    public ConvertRomanRequest(String result) {
        this.roman = result;
    }

    public String getRoman() {
        return roman;
    }

    public void setRoman(String roman) {
        this.roman = roman;
    }
}
