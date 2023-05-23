package com.heavensentlocator.backend.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heavensentlocator.backend.data.User;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

//this is class is the API portion 
@RestController
@CrossOrigin
public class UserControl {
    //store all of the data two serperate arrays for user obj and images obj
   static List<User> myList =new ArrayList<User>();
   static List<Images> images = new ArrayList<>();

    //method put data automatically in arrays when u start up code 
    public static void init(){
        myList.add(new User(0, "-81.7812381", "32.4275135",1));
        myList.add(new User(1, "-81.768886","32.411617",1));
        myList.add(new User(1, "-81.7757162,","32.4111477",1));

        
        try {
            File imageFile = new File("backend\\backend\\backend\\src\\main\\java\\com\\heavensentlocator\\backend\\images\\location1.jpg");
            byte[] imageBytes;
            imageBytes = Files.readAllBytes(imageFile.toPath());
            File imageFile1 = new File("backend\\backend\\backend\\src\\main\\java\\com\\heavensentlocator\\backend\\images\\location2.jpg");
            byte[] imageBytes1 = Files.readAllBytes(imageFile1.toPath());
            File imageFile2 = new File("backend\\backend\\backend\\src\\main\\java\\com\\heavensentlocator\\backend\\images\\location3.jpg");
            byte[] imageBytes2 = Files.readAllBytes(imageFile2.toPath());
            
            
            images.add(new Images(imageBytes,1));
            images.add(new Images(imageBytes1,1));
            images.add(new Images(imageBytes2,1));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        

       
    }
    //sends a JSON string of the myList array of users to the localhost:8080/user 
    @GetMapping("/user")
    public String showUsers(Model mode)  throws IOException{

            System.out.println(myList);
             //part where the array is converted to JSON
             ObjectMapper mapper = new ObjectMapper();
             String jsonStr = mapper.writeValueAsString(myList);
             mode.addAttribute("user", myList);
             return jsonStr.toString();
    }
    
    //sends a JSON string of the myList array of users to the localhost:8080/image 
    @GetMapping("/image")
    public String getImages()  throws IOException {
        //part where the array is converted to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(images);
        return jsonStr.toString();
    }
    //grabs a JSON string of the User obj and add its the new Data to the User array
    @PostMapping("/addUser")
    public void addData(@RequestBody User newData) {
        // convert new data from JSON string to Java object
        int id=newData.getId();
        String longittude=newData.getLongittude();
        String latitude=newData.getLatitude();
        int uniqueID=newData.getbraceletNo();
        System.out.print("HELLO");

        myList.add(new User(id, longittude, latitude,uniqueID));
    }

    //grabs a JSON string of the Image obj and add its the new Data to the Image array
    @PostMapping("/addImage")
    public void addData(@RequestBody Images newData) {
        // convert new data from JSON string to Java object
        byte[] imageBytes4=newData.getImageBytes();
        int braceletNo=newData.getbraceletNo();
        images.add(new Images(imageBytes4,4));

        System.out.print("BYE");

    }
}
