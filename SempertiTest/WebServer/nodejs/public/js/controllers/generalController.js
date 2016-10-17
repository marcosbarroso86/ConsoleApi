app.controller("generalController" , ["$scope" , function($scope){

	$scope.csdversion="";
	$scope.csname="";
	$scope.name="";
	$scope.numberOfLicensedUsers="";
	$scope.registeredUser="";
	$scope.serialNumber="";
	$scope.version="";
	$scope.windowsDirectory="";
	$scope.installDate="";
	$scope.localDateTime="";

	$scope.socket = io.connect("http://localhost:3000" , { 'forceNew': true });

	$scope.socket.on("GENERAL", function(data){

			data = JSON.parse(data);			
			$scope.csdversion=data[0].value;
			$scope.csname=data[1].value;			
			$scope.installDate=data[2].value;
			$scope.localDateTime=data[3].value
			$scope.name = data[4].value;
			$scope.numberOfLicensedUsers=data[5].value;
			$scope.registeredUser=data[6].value;
			$scope.serialNumber = data[7].value;
			$scope.version=data[8].value;			
			$scope.$apply();
		
	});

}])