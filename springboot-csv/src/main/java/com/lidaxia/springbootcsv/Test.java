package com.lidaxia.springbootcsv;

import lombok.Data;

/**
 * @author lidaxia
 * @desc
 * @date 2022/1/12 11:26
 */
@Data
public class Test {

    @CsvField("text")
    private String text;

    @CsvField("label")
    private String label;

    public Test(String text, String label) {
        this.text = text;
        this.label = label;
    }
}
