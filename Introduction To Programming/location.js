var locs = [];
var items = [];
var tryDead = false;

//This is the Location Prototype
function Location(id, name, description, item, keyLoc){
	this.id = id;//id is the location #
	this.name = name;//name is the location name 
	this.description = description;//this is the locations description
	this.cDescription = description;//this is a description variable that can be altered accordingly
	this.item = item;//item is the item stored in the location. Not every location will have one.
	this.keyLoc = keyLoc;//keyLoc is the location of the Key for the location being constructed.
	this.visited = false;//Visited indicates if the user has been to the location.
	//The update display function is stored in the Location prototype for convenience. 
	this.updateDisplay = function(message){
		var locBox =document.getElementById("Loc");//index for the score
		var cVal= locBox.value;//for current Value
		locBox.value=message+"\n\n" + cVal;//appends the message to the front of the existing String
	}
	//Update score adds five points to the current score if the location has not been visited and displays the new score.
	this.updateScore = function(){
		var scoreBox =document.getElementById("Score");//index for the score
		if(!this.visited){//if the location has not been visited.
			scoreBox.value=Number(scoreBox.value)+5; //adds 5 to the score and displays in the score box
			this.visited=true;//If the score is being updated the Location has been visited.
		}
	}
	//This function covers all of the actions for the Location Objects when they are being moved to
	this.goTo = function(){
		userLoc=this.id;//changes the user's Location to the Location being moved to
		disable(userLoc);
		// cDiscription is the current description
		//The cDescription will only differ from the standard description if:
		//  their is an item 
		//  the user doesn't have the key for the location
		this.cDescription = "#"+this.id+" "+this.name+": "+this.description;
		if(this.hasKey()){//If the the user has the key for the Location
			this.updateScore();
			//this prompts users to take an item if one is available
			if(this.item!=undefined&&item.itemGot==false){
				this.cDescription+=this.item.description;//the items description added to the current description
				this.updateDisplay(this.cDescription);
				this.item.take();//The user is prompted to take the item.
			}
			else{//if their is no item to take
				if(this.id==9) {//if at the winning location
					this.updateDisplay(this.cDescription);
					alert("Congratulations you made it out alive!!!");
				}
				if(this.id==8) {//if at the dying location
					var choose =Math.random()*100;//choose a random number between 0-100
					if(choose>25&&tryDead==false){//randomly if user will die
						locs[10].goTo();
						var reset = prompt("You died!!! Would you like to restart? Respond \"Y\" or\"N\"", "");
						if((reset=="y")||(reset=="Y")){
							window.open(document.URL);
							window.close();
						}
					}
					else{//if not killing user
						tryDead=true;//do not attempt to kill again.
					}
					
				}
				else this.updateDisplay(this.cDescription);
			}
		}
		else{//if their is no key 
				this.updateDisplay(this.cDescription);
		}
		tryDead=false;
				
	}
	//Evaluates if their is a key for the location and alerts the user if they dont have it.
	this.hasKey = function(){
		if(this.keyLoc==undefined){//if there is no key
			return true;//They don't need a key so they have one
		}
		else if(this.keyLoc.item.itemGot==false){//if they dont have the key yet
			//the current description informs the user to go find the item needed for the Location
			this.cDescription = "You need "+ this.keyLoc.item.name +" to go further. Go to find the "+this.keyLoc.item.name+". ";
			return false;//They do need a key and they dont have it
		}
		else{
			return true;//They have the key. 
		}
	}
	//This function was written to enable defining the keyLoc after the Location is created
	this.setKeyLoc = function(kL){
		this.keyLoc=kL;
	}
	//This is and override of the toString function.
	//It will return the id, name and description of the Location
	this.toString = function(){
		var s = "id: "+this.id+"\n name: "+this.name+"\n description"+this.description;
		return s;
	}
	
}

//This is the Item prototype
function Item(id, name, description){
	this.id = id;//id that corresponds to the items Location
	this.name = name;//The name of the item; what it is.
	this.description = description;//A description of how the item appears in its location
	this.itemGot = false;//The itemGot variable indicates if an item has been taken.
	//Prompts the user to take the Item.
	//and adds it to the items[] array
	this.take=function(){
		if(!this.itemGot){//If the item was not already taken
			//prompt the user to take it
			var taken = prompt("May be important, would you like to take the "+this.name+" ? Respond \"Y\" or\"N\"", "")
			if((taken == 'Y')||(taken == 'y')){//If they choose to take it
				this.itemGot=true;//The item is gotten
				items.push(this.name);//The item is added to the items[] array
			} 
		}
	}
	//This is and override of the toString function.
	//It will return the id, name and description of the Item
	this.toString = function(){
		return "id: "+this.id+"\n name: "+this.name+"\n description"+this.description;
	}
	
}

//The following is the declaration of all the locations in the game.
//After declaration they are added to the locs array
//The variable dscrp is recycled through the declaration of all the location variables
//This is done for readability 
//The variable for the Items are defined separately for readability as well.
var dscrp = "You are in the center of a room with two doors, a window, and a shower.";
locs.push(new Location(0, "Home", dscrp));
dscrp = "Now your in the shower.";
locs.push(new Location(1, "Shower", dscrp));
dscrp="Eastward is a door from the center of the room. After opening the door you find yourself in an intense sand storm. You cannot see in front of you.";
locs.push(new Location(2, "Sandstorm", dscrp));
dscrp="Southward is a door from the center of the room. After opening the door you are suronded by a purple light illuminating from a narrow tower in front of you.";
var glowStick = new Item(3, "glow stick", " Near the tower is a green glow stick.");
locs.push(new Location(3, "Purple Door",dscrp, glowStick));
dscrp="Westward is a window from the center of the room. Outside the window you see water that moves like the sea but looks as wide as the ocean. Through the window you can see the horizon and many fish below it.";
locs.push(new Location(4, "Window", dscrp));
dscrp = "You open the window and hoist yourself through. The water does not spill into the room. As you tread the water you see something in the distance.";
locs.push(new Location(5, "Water", dscrp));
dscrp = "You swim out farther. ";
var quill = new Item(6, "quill", " You see a wooden quill bobbing in the water. The end of it is strange. ");
locs.push(new Location(6, "Deep Blue ???", dscrp, quill));
dscrp = "The storm swirls behind you. Up ahead is a large shipping carrier crate.";
var scissors = new Item (7, "scissors"," On the ground are a pair of scissors.");
locs.push(new Location(7, "The Crate", dscrp, scissors));
dscrp = "You walk through a dank and dimly lit hallway and find a kiddy pool.";
var flippers = new Item(8, "flippers", " In the pool are a pair of flippers.");
locs.push(new Location(8, "Kiddy Pool", dscrp, flippers));
dscrp = "You see an familiar red exit sign over a set of big metal doors. After walking through the doors you're blinded by sunlight. You see men with ladders, fake trees, and animals walking all directions. A golf cart driven by an angry woman on a cell phone nearly runs you over. You get to the middle of the street and notice that you've been on a special FX movie set this whole time. THE END.";
locs.push(new Location(9, "EXIT", dscrp));
dscrp = "You fell down a hole and broke three ribs. You bled out and now you dead. GAME OVER!"
locs.push(new Location(10, "Kill", dscrp));
//The key locations are defined here because some key Locations are declared after the 
//location that uses them is defined so keyLocs must be defined after the locations are
//all declared.
locs[3].setKeyLoc(locs[7]);
locs[6].setKeyLoc(locs[8]);
locs[8].setKeyLoc(locs[3]);
locs[9].setKeyLoc(locs[6]);
//disables a button and changes color (to gray) to indicate that it is disabled according
//to the button's id.
function disable(Loc){
	switch(Loc){
		case 0:
		case 3:
		case 7:
		case 8:document.getElementById("N").disabled = false;
			   break;
			 default:document.getElementById("N").disabled = true;
	}
	switch(Loc){
		case 0:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 8:document.getElementById("E").disabled = false;
			   break;
			 default:document.getElementById("E").disabled = true;
	}
	switch(Loc){
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 10:document.getElementById("S").disabled = true;
			   break;
			 default:document.getElementById("S").disabled = false;
	}
	switch(Loc){
		case 1:
		case 3:
		case 6:
		case 9:
		case 10:document.getElementById("W").disabled = true;
			   break;
			 default:document.getElementById("W").disabled = false;
	}
}	

