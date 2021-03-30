var test;


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
        dataType: "json",
		success: function(response) {
        test = response;
		console.log(test);
    }
    })
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


function callDone(result){
	var templateExample = _.template($('#templateExample').html());
	response = result;
	var html = templateExample({
		"attribute":JSON.stringify(result)
	});
	
	$("#result").append(html);

}

$(function(){
	$("#button3").click(function(){
	var username = "Trizy";
	postServerData("/ws/services/users/Remsi/addFriend",username,callDone);
	});
});

$(function(){
	$("#button").click(function(){
	var username = "Remsi";
	postServerData("ws/services/users/create",username, callDone);

	//console.log((test));
	
	});
});

$(function(){
	$("#button4").click(function(){
	var username = "Trizy";
	postServerData("ws/services/users/create", username, callDone);
	});
});

$(function(){
	$("#button2").click(function(){
	getServerData("/ws/services/users/search/Remsi",callDone);
	});
});

$(function(){
	$("#button5").click(function(){
	getServerData("/ws/services/users/search/Trizy",callDone);
	});
});

$(function(){
	$("#DeleteR").click(function(){
	getServerData("/ws/services/users/delete/Remsi",callDone);
	});
});


$(function(){
	$("#GetPin").click(function(){
	getServerData("/ws/services/pins/search/1",callDone);
	});
});


$(function(){
	$("#CreatePin").click(function(){
		var pin = {
			user: "Trizy",
			title: "TItre",
			description: "Desc",
			tags: null,
			latitude: 4,
			longitude: 7
			};
	postServerData("/ws/services/pins/create", JSON.stringify(pin), callDone);
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});
	
	//$("#result").append(html);
	console.log($(value));
	});
});


