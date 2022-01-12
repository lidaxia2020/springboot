package com.lidaxia.springbootcsv;

/**
 * @author lijiannan
 * @desc
 * @date 2022/1/12 11:23（
 */
public abstract class CsvConvertHandler<T extends Object> implements CsvConvertVisitable {
    @Override
    public String convert(Object value) {
        return this.get((T) value);
    }

    protected abstract String get(T value);

    public abstract static class None extends CsvConvertHandler {
        public None() {
        }
    }
}