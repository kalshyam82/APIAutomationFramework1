package com.tmb.utils;

import static com.tmb.utils.FakerUtils.*;

public final class RandomUtils {
     private RandomUtils(){}

    public static int getID(){

         return getNumber(1000, 2000);
    }

    public static String getfName(){

         return FakerUtils.getFirstName();
    }

    public static String getlName(){
         return FakerUtils.getLastName();
    }

//    public static String getEmail(){
//        return FakerUtils.getEmail();            b
//    }
}
