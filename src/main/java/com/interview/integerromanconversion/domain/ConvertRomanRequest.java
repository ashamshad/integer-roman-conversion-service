package com.interview.integerromanconversion.domain;

import javax.validation.constraints.Pattern;

public class ConvertRomanRequest {
    @Pattern(regexp = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")
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
