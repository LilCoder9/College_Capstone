import React, { useEffect, useState } from "react"
import './gallery.css'
import CloseBtn from'./img/exit-icon.png'
import axios from "axios";
import Maps from "./Maps/GoogleMaps"

const Gallery = () =>{
    //idk
    useEffect(()=> {
    const handleChildChange = async () => {
       var lastLat =await users[users.length - 1].latitude;
       var lastLong = await users[users.length - 1].longittude;
       console.log(lastLat)
       console.log(lastLong)
      };
      handleChildChange();
    })

//this part of the code is where you grab the JSON from /user and store it inside users for the frontend
const [users,setUser] = useState([]);
useEffect(()=> {
    const getUser = async ()=>{
        axios.get("http://localhost:8080/user").then(response => {
        setUser(response.data)
        console.log(response.data);
        
    })
        
    }
    getUser();
},[]);

//this part of the code is where you grab the JSON from /image and store it inside img
const [img,setImg] = useState([]);
useEffect(() =>{
    const getImg = async()=>{
        axios.get("http://localhost:8080/image").then(response=>{
            setImg(response.data)
            console.log(response.data)
        })
    }
    getImg();
},[]);



//when u click on the image and popups a new component
const [model, setModel] = useState(false);
const[tempImg, setTempImg]= useState(''); 
const[popUpMap,setpopUpMap]=useState('');   

const getImg = (imgSrc,mapIndex)=>{
    setpopUpMap(users[mapIndex]);
    console.log(mapIndex);
    setTempImg(imgSrc);
    setModel(true);
   
}
    return(
        <>
        {/*  pop up component */}
        <div className={model ? "model open": "model"}>
           <Maps className="map" long={popUpMap.longittude} lat={popUpMap.latitude} /> 
            <img src={tempImg} className="popup" />    
            <img src={CloseBtn} className="close" style={{position:'absolute', top:'0px', right:'0px'}} onClick={()=> setModel(false) }/>
            <div class="text-box">TEXT HERE</div>
            <div class="back-box"></div>
        </div>
        {/* displays a 3 row list of images */}
        <div className="gallery">
        {img.map((item, index)=>{
          const src = `data:image/jpg;base64,${item.imageBytes}`
          const click = index;
                return(
                    <div className="pics" key={index} onClick={()=> getImg(src,click)}>
                            <img src={src} style={{width: '100%'}}/>
                        </div>
                )
            })}
        </div>
        </>
    
    )
}

export default Gallery