package com.ubs.opsit.interviews;

public enum NumberConstant{
    TWO(2),
    Five(5);

    public final Integer value;

    NumberConstant(Integer value){
        this.value =value;
    }
    public static Integer valueOfEnum(String value){
        NumberConstant numberConstant = NumberConstant.valueOf(value);
        return numberConstant.value;
    }

}
