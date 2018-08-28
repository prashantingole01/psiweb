package com.ubs.opsit.interviews;

public enum LedConstant {

    YELLOW('Y'),RED('R'),OFF('O');

    private final char value;

    LedConstant(char value){
        this.value=value;
    }

    public static char valueOfEnum(String value){
        LedConstant ledConstant = LedConstant.valueOf(value);
        return ledConstant.value;
    }
}
