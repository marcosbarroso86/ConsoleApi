app.controller("cpuController" , [ "$scope" , function($scope){
		
	$scope.loadPercentage ="";
	$scope.currentClockSpeed;
	$scope.name = "";
	$scope.maxClockSpeed="";
	$scope.list="";
	$scope.processorId="";
	$scope.caption=""
	$scope.socketDesignation=""
	$scope.currentVoltage;
	$scope.L2CacheSize;
	$scope.manufacturer;
	$scope.version;
	$scope.addressWidth;


	$scope.socket = io.connect("http://localhost:3000" , { 'forceNew': true });

	$scope.socket.on("CPU_DYNAMIC_DATA", function(data){

			data = JSON.parse(data);

			
			$scope.addressWidth=data[0].value;
			$scope.caption=data[1].value;			
			$scope.currentClockSpeed = data[2].value;
			$scope.currentVoltage=data[3].value;
			$scope.L2CacheSize=data[5].value;
			$scope.loadPercentage = data[4].value;
			$scope.manufacturer=data[6].value
			$scope.maxClockSpeed = data[7].value;
			$scope.name = data[8].value;
			$scope.processorId = data[9].value
			
			$scope.$apply();
		
	});

	$scope.socket.on("CPU_STATIC_DATA" , function(data){

		$scope.list = JSON.parse(data);
	})
}]);
