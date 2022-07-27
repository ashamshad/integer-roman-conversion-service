package com.interview.integerromanconversion.domain;

import javax.validation.constraints.Max;

public class ConvertIntegerRequest {
    @Max(3999)
    private Integer integer;

    public ConvertIntegerRequest() {}

    public ConvertIntegerRequest(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
