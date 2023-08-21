/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnoservices.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Janus
 */
public class ResponseRest {
    
    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(String type, String code, String date) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("code", code);
        map.put("date", date);
        
        metadata.add(map);
    }
    
    
    
}
