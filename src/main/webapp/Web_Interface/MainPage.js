var map;
var placingPin = false;
var currentPin = null;
var pinIdNumber = 0;

const MAP_BOUNDS = {
    north: 85,
    south: -85,
    west: -180,
    east: 180,
};


function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function postServerData(url, data, success){
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function putServerData(url, data, success){
    $.ajax({
        type: 'PUT',
        url: url, 
        data: data,
        contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function initMap() {
    
    //Initializing the map
    map = new google.maps.Map(document.getElementById("map"), {
        draggableCursor:'default',
        center: { lat: 0, lng:0},
        zoom: 3,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
            position: google.maps.ControlPosition.BOTTOM_RIGHT
        },
        fullscreenControlOptions: {
            position: google.maps.ControlPosition.BOTTOM_RIGHT
        },
        restriction: {
            latLngBounds: MAP_BOUNDS,
            strictBounds: true  
        }
    });

    //Adding a listener (cancel action)
    google.maps.event.addListener(map, 'rightclick', function(e) {cancelAction();
    });
    
    //Adding a listener (place a pin)
    google.maps.event.addListener(map, 'click', function(e) {clickOnMap(e.latLng);
    });

}

function clickOnMap(location) {

    //Unselect currentPin
    if (currentPin!=null){

        unselectPin(currentPin);

    }
    
    //If placing a pin
    if (placingPin == true){


        //Set marker icon
        var icon = {
            url: "./Resource/Marker.png",
            scaledSize: new google.maps.Size(35, 35)
        };

        
        //Place the marker
        var marker = new google.maps.Marker({
            position: location, 
            map: map,
            icon: icon,
            id: pinIdNumber
        });
        
        //Adding a Listener
        marker.addListener('click', function (e){ selectPin(marker);
        });
        
        //Select the pin
        selectPin(marker);
        
        //Reset the cursor to drag
        map.setOptions({draggableCursor:'default'});
        
        //Adding one to the pinIdNumber
        pinIdNumber += 1;
        
        
        //Open up the modal window
        $("#createPinModal").show();
        
        //Reset placingPin
        placingPin = false;
        
    }
    
}

function selectPin(pin){
   
    //Initializing marker icons
    var selectIcon = {
        url: "./Resource/Marker.png",
        scaledSize: new google.maps.Size(50, 50)
    };

    //If the pin is alread selected, we unselect it
    if (pin === currentPin){

        unselectPin(pin);
        
    }    

    else {
        
        //Unselect any ppotential currentPin
        unselectPin(currentPin);

        //Select the new Pin
        var currentPinPanel = document.getElementById("currentPinPanel");
        pin.setIcon(selectIcon);
        currentPinPanel.style.display = "block";
        currentPin = pin;

        //Fill the currentPin Panel
        $("#pinTitle").text("Pin n° " + pin.id);

    }
    
}

function unselectPin(pin){

    if(pin != null){
        
        var unselectedIcon = {
            url: "./Resource/Marker.png",
            scaledSize: new google.maps.Size(35, 35)
        };
        
        var currentPinPanel = document.getElementById("currentPinPanel");
        pin.setIcon(unselectedIcon);
        currentPinPanel.style.display = "none";
        currentPin = null;
        
    }

}

function cancelAction(){

    //Reset the cursor to drag
    map.setOptions({draggableCursor:'default'});

    //Refresh ?

    //Reseting every action
    placingPin = false;

}

function addPin(){
    
    //Allowing the user to place a pin
    placingPin = true;
    
    //Set the cursor to pin
    map.setOptions({draggableCursor:'crosshair'});
    
}

function deletePin(){
    
    if(currentPin!=null){

        currentPin.setMap(null);
        unselectPin(currentPin);
        currentPin = null;

    }
    
}

//Close the modal window
function closeCreatePinModal() {
    
    $(".modal").hide();
    deletePin(currentPin);
    unselectPin(currentPin);

} 

//jQuery (runs when page is loaded)
$(document).ready(function($) {

    $("#addPinButton").click(addPin);
    $("#deletePinButton").click(deletePin);
    $("#closeCreatPinModal").click(closeCreatePinModal);
    //$("#createPinModal").click(closeCreatePinModal);
    document.getElementById("currentPinPanel").style.display = "none";

});
