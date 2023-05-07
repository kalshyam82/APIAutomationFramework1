package com.tmb.tests;

import lombok.Getter;
@Getter
public class FCwithSingleton {

    private static FCwithSingleton INSTANCE = null;

    private FCwithSingleton(){}




    private final String requestJsonFolderPath = System.getProperty("user.dir")+"/src/test/resources/jsons/";
    private final String responseJsonFloderPath = System.getProperty("user.dir")+"/output/";

    public static synchronized FCwithSingleton getInstance(){
        if(INSTANCE==null){
            INSTANCE=new FCwithSingleton();
        }
        return INSTANCE;
    }
}
