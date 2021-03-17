var map;
var placingPin = false;

const MAP_BOUNDS = {
    north: 85,
    south: -85,
    west: -180,
    east: 180,
};

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
    google.maps.event.addListener(map, 'click', function(e) {placeMarker(e.latLng);
    });

}

function placeMarker(location) {

    if (placingPin == true){
        
        //Place the marker
        var marker = new google.maps.Marker({
            position: location, 
            map: map
        });
        
        //Reset the cursor to drag
        map.setOptions({draggableCursor:'default'});

        //Reset placingPin
        placingPin = false;
        
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

//jQuery (runs when page is loaded)
$(document).ready(function($) {

    $("#addPinButton").click(addPin);

});

