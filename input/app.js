
function runInput(){
// create a new XMLHttpRequest object
const xhr = new XMLHttpRequest();

// specify the request method and URL
xhr.open('POST', 'http://localhost:8080/addUser');

// set the content type to JSON
xhr.setRequestHeader('Content-Type', 'application/json');

// create a JavaScript object
var long = document.getElementById("long").value
var myLong=long.toString()
var lat = document.getElementById("lat").value
var myLat=lat.toString()
var braceletNo = document.getElementById("braceletNo").value
var myNumber = parseInt(braceletNo);
const data = { id: 0, longittude: myLong, latitude: myLat, braceletNo: myNumber };

// convert the JavaScript object to JSON
const json = JSON.stringify(data);

// send the JSON data in the request body
xhr.send(json);
}

function runImage(){
fileSelect = document.getElementById("fileUp").files;
if(fileSelect.length > 0){
    var fileSelect = fileSelect[0];
    var fileReader = new FileReader();
   
    fileReader.onload = function(FileLoadEvent){
        var srcData =FileLoadEvent.target.result;

            // document.getElementById("imageFile").src = srcData;
            // document.getElementById("Base64").innerHTML = srcData.slice(22);
            var imageOutput= srcData.slice(22);
            //create a new XMLHttpRequest object
        const xhr = new XMLHttpRequest();

// specify the request method and URL
xhr.open('POST', 'http://localhost:8080/addImage');

// set the content type to JSON
xhr.setRequestHeader('Content-Type', 'application/json');

// convert the JavaScript object to JSON
const data = { imageBytes:imageOutput, braceletNo: 40 };
const json = JSON.stringify(data);

// send the JSON data in the request body
xhr.send(json);
    }
    
    fileReader.readAsDataURL(fileSelect);
    
}
}
