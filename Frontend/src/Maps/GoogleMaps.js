import React from "react";
import "./GoogleMaps.css"

//this function displays a map component of an specific latitude and longtitude
function GoogleMaps(props){
    const string = `https://maps.google.com/maps?q=${props.lat},${props.long}&hl=es;&output=embed`
    
    return(
        <div>
            <iframe className="map" src={string} ></iframe>
        </div>
    )

}
export default GoogleMaps;