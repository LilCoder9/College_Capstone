package com.heavensentlocator.backend.data;


//object to store images for the user
public class Images {

    private byte[] imageBytes;
    private int braceletNo;

  

    public Images(byte[] imageBytes,int braceletNo) {
        this.imageBytes = imageBytes;
        this.braceletNo = braceletNo;
    }

    public int getbraceletNo() {
        return braceletNo;
    }

    public void setbraceletNo(int braceletNo) {
        this.braceletNo = braceletNo;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }
}
