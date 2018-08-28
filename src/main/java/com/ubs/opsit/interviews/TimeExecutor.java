package com.ubs.opsit.interviews;

class TimeExecutor implements TimeConverter {

    private StringBuilder firstRow ;
    private StringBuilder secondRow;
    private StringBuilder thirdRow ;
    private StringBuilder fourthRow;


    public TimeExecutor() {
        firstRow = new StringBuilder("OOOO");
        secondRow = new StringBuilder("OOOO");
        thirdRow = new StringBuilder("OOOOOOOOOOO");
        fourthRow = new StringBuilder("OOOO");
    }

    @Override
    public String convertTime(String aTime) {

        String[] splitValues = aTime.split(TimeConstants.SPLIT_CHARACTER);
        String hours =splitValues[0];
        String minutes = splitValues[1];
        String seconds = splitValues[2];

        return calculateTime(hours,minutes,seconds);
    }

    public String calculateTime(String hour,String minute,String second) {

        StringBuilder result =new StringBuilder();

        Integer onOff = Integer.parseInt(second)%NumberConstant.valueOfEnum(TimeConstants.TWO);

        getIndicator(onOff,result);

        Integer hours = Integer.parseInt(hour)/NumberConstant.valueOfEnum(TimeConstants.Five);
        result.append(getHour(hours,firstRow).append(TimeConstants.NEW_LINE));

        Integer remainingHours = Integer.parseInt(hour)%NumberConstant.valueOfEnum(TimeConstants.Five);
        result.append(getHour(remainingHours,secondRow).append(TimeConstants.NEW_LINE));

        int minutes = Integer.parseInt(minute)/NumberConstant.valueOfEnum(TimeConstants.Five);
        result.append(getMinutes(minutes,thirdRow).append(TimeConstants.NEW_LINE));

        Integer remainingMinute = Integer.parseInt(minute)%NumberConstant.valueOfEnum(TimeConstants.Five);
        result.append(getRemainingMinutes(remainingMinute,fourthRow));

        return result.toString();
    }

    private StringBuilder getIndicator(Integer onOff,StringBuilder builder){

        if(onOff == 0){
            builder.append(LedConstant.valueOfEnum(TimeConstants.YELLOW)).append(TimeConstants.NEW_LINE);
        }else{
            builder.append(LedConstant.valueOfEnum(TimeConstants.OFF)).append(TimeConstants.NEW_LINE);
        }
        return builder;
    }

    private StringBuilder getHour(Integer hours,StringBuilder builder) {

        for (int hourCounter=0; hourCounter < hours; hourCounter++){
            builder.setCharAt(hourCounter, LedConstant.valueOfEnum(TimeConstants.RED));
        }
        return builder;
    }

    private StringBuilder getMinutes(Integer minutes,StringBuilder builder){

        for(Integer counter=0; counter < minutes; counter++){
            switch(counter){
                case 2:
                case 5:
                case 8:
                    thirdRow.setCharAt(counter, LedConstant.valueOfEnum(TimeConstants.RED));
                    break;
                default:
                    thirdRow.setCharAt(counter, LedConstant.valueOfEnum(TimeConstants.YELLOW));
            }
        }
        return thirdRow;
    }

    private StringBuilder getRemainingMinutes(Integer remainingMinute,StringBuilder builder){

        for(int counter =0 ; counter < remainingMinute; counter++){
            fourthRow.setCharAt(counter, LedConstant.valueOfEnum(TimeConstants.YELLOW));
        }
        return fourthRow;
    }

}
