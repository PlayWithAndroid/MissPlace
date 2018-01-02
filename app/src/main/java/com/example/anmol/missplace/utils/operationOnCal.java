package com.example.anmol.missplace.utils;

import java.util.HashMap;

public class operationOnCal {

    HashMap hashMap;

    public operationOnCal(){
        hashMap = new HashMap();
        hashMap.put(0,"JAN");
        hashMap.put(1,"FEB");
        hashMap.put(2,"MAR");
        hashMap.put(3,"APR");
        hashMap.put(4,"MAY");
        hashMap.put(5,"JUN");
        hashMap.put(6,"JUY");
        hashMap.put(7,"AUG");
        hashMap.put(8,"SEP");
        hashMap.put(9,"OCT");
        hashMap.put(10,"NOV");
        hashMap.put(11,"DEC");
    }

    public String getMonth(int index){
        return String.valueOf(hashMap.get(index));
    }

    public String getProperDate(int index){
            if (index<10){
                return String.valueOf("0"+index);
            }
            else{
                return String.valueOf(index);
            }
    }

}
