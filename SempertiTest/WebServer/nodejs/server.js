var express = require("express");
var app = express();
var http = require("http").Server(app);
var io = require("socket.io")(http);

var CPU_EVENT_STC = "CPU_STATIC_DATA";
var CPU_EVENT_DYM = "CPU_DYNAMIC_DATA";
var MEMORY_EVENT = "MEMORY";
var GENERAL_EVENT = "GENERAL";

http.listen(3000 , function(){
	console.log("server running on port 3000");
});

app.use(express.static(__dirname + "/public"));

app.get("/" , function(request , response) {
	response.sendFile(__dirname + '/index.html');
});

io.on('connection', function(socket){
  
  socket.on(CPU_EVENT_DYM, function(msg){
      io.sockets.emit(CPU_EVENT_DYM, msg);
	});

  socket.on(CPU_EVENT_STC, function(msg){
      io.sockets.emit(CPU_EVENT_STC, msg);
	});

  socket.on(MEMORY_EVENT, function(msg){
      io.sockets.emit(MEMORY_EVENT, msg);
	});
  
  socket.on(GENERAL_EVENT, function(msg){
      io.sockets.emit(GENERAL_EVENT, msg);
	});
  socket.on('disconnect', function () {
    io.emit('user disconnected');
  });



});