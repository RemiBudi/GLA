var map;
var placingPin = false;
var currentPin = null;
var createdPin = null;
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

function putSuccessFunction(result){

    console.log(result);

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
        //selectPin(marker);
        
        //Setting the created Pin to the maker
        createdPin = marker;

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

function createPin(){

    //Get the values inputed by the user
    var title = $("#creatPinModalName").val();
    var description = $("#creatPinModalDescription").val();


    if (title == ""){

        alert("You must add a valid Title!");

    }

    else if(title.length > 30){

        alert("Your Title is too long! (30 characters max.)");

    }
    
    else if(description.length > 200){

        alert("Your Description is too long! (200 character max.)");

    }

    else{
        
        //Hide the modal window
        $("#createPinModal").hide();
        
        //Add properties to the pin
        createdPin.pinTitle = title;
        createdPin.pinDescription = description; 
    
        //Clear the textBoxes
        $("#creatPinModalName").val('');
        $("#creatPinModalDescription").val('');
        

        //Creating a new object to send
        var myPin = {

            id: createdPin.id,
            user: 0,
            title: title,
            description: description,
            tags: null,
            latitude: createdPin.position.lat(),
            longitude: createdPin.position.lng()
            
        };
        
        //Send the pin WS
        postServerData("ws/services/pins/create", JSON.stringify(myPin), putSuccessFunction);
       
        //select the createdPin
        selectPin(createdPin);
	

        //Set createdPin back to null
        createdPin = null;
        
    }

}

function editPin(){

    //Get the values inputed by the user
    var title = $("#editPinModalName").val();
    var description = $("#editPinModalDescription").val();

    if (title == ""){

        alert("You must add a valid Title!");

    }

    else if(title.length > 30){

        alert("Your Title is too long! (30 characters max.)");

    }
    
    else if(description.length > 200){

        alert("Your Description is too long! (200 character max.)");

    }

    else{
        
        //Hide the modal window
        $("#editPinModal").hide();
        
        //Add properties to the pin
        currentPin.pinTitle = title;
        currentPin.pinDescription = description; 
    
        //Clear the textBoxes
        $("#editPinModalName").val('');
        $("#editPinModalDescription").val('');
        
        //Creating a new object to send
        var myPin = {

            id: currentPin.id,
            user: 0,
            title: title,
            description: description,
            tags: null,
            latitude: currentPin.position.lat(),
            longitude: currentPin.position.lng()
            
        };
        
        //Send the pin WS
        postServerData("ws/services/pins/edit", JSON.stringify(myPin), putSuccessFunction);
       
        //select the pin
        //selectPin(currentPin);

        //Update the currentPinDisplay
        getServerData("ws/services/pins/search/"+currentPin.id, refreshCurrentPinPanel)

        //Close the editPinModal
        $("#editPinModal").hide();
        
    }

}

function refreshCurrentPinPanel(pin){

    $("#pinTitle").text(pin.title);
    $("#pinDescription").text(pin.description);
    $("#pinTitle").height( $("#pinTitle")[0].scrollHeight);

    //DEBBUG
    console.log("Titre: " + pin.title);
    console.log("Description: " + pin.description);
    console.log("ID: " + pin.id);

    //TODO rezise

}

function selectPin(pin){
   
    //Initializing marker icons
    var selectIcon = {
        url: "./Resource/Marker.png",
        scaledSize: new google.maps.Size(50, 50)
    };

    
    //If the pin is null, there is a probleme
    if (pin==null){
       
        alert("The pin is NULL");

    }   
    
    //If the pin is alread selected, we unselect it
    else if (pin === currentPin){

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

        //Get the pin from WS
        getServerData("ws/services/pins/search/"+pin.id, refreshCurrentPinPanel)

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
function cancelCreatePinModal() {
    
    $(".modal").hide();
    deletePin(createdPin);
    createdPin = null;

} 


//Close the modal window
function cancelEditPinModal() {
    
    $(".modal").hide();

} 


//jQuery (runs when page is loaded)
$(document).ready(function($) {

    $("#addPinButton").click(addPin);
    $("#deletePinButton").click(deletePin);
    $("#closeCreatPinModal").click(cancelCreatePinModal);
    $("#creatPinModalCancelButton").click(cancelCreatePinModal);
    $("#creatPinModalCreatePinButton").click(createPin);

    $("#editPinButton").click(function(){
        $("#editPinModalName").val(currentPin.pinTitle);
        $("#editPinModalDescription").val(currentPin.pinDescription);
        $("#editPinModal").show();
    })
    $("#editPinModalCancelButton").click(cancelEditPinModal);
    $("#closeEditPinModal").click(cancelEditPinModal);
    $("#editPinModalEditPinButton").click(editPin);


    document.getElementById("currentPinPanel").style.display = "none";

});

