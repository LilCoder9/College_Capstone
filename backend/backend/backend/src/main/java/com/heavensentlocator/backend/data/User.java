package com.heavensentlocator.backend.data;

import java.util.List;

//This is the Object that will store the long,lat and braceletNo for the user bracelet
public class User {
    
    private int id;
    private String longittude;
    private String latitude;
    private int braceletNo;
    


    public User(int id, String longittude, String latitude, int braceletNo) {
        this.id = id;
        this.longittude = longittude;
        this.latitude = latitude;
        this.braceletNo = braceletNo;
        
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLongittude() {
        return longittude;
    }
    public void setLongittude(String longittude) {
        this.longittude = longittude;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getbraceletNo() {
        return braceletNo;
    }


    public void setbraceletNo(int braceletNo) {
        this.braceletNo = braceletNo;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"longittude:\":\""+longittude+"\",\"latitude\":\""+latitude +"\",\"image\":\""+"\"}";
    } 


}
