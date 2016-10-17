app.controller("memoriaController" , ["$scope" , function($scope){
	
	$scope.freePhysicalMemory ="";
	$scope.freeSpaceInPagingFiles;
	$scope.freeVirtualMemory = "";
	$scope.totalVirtualMemorySize="";
	$scope.totalVisibleMemorySize="";
	$scope.maxProcessMemorySize;
	$scope.maxNumberOfProcesses;
	$scope.numberOfProcesses;
	$scope.sizeStoredInPagingFiles;

	$scope.socket = io.connect("http://localhost:3000" , { 'forceNew': true });

	$scope.socket.on("MEMORY", function(data){

			data = JSON.parse(data);
			$scope.freePhysicalMemory=data[0].value;
			$scope.freeSpaceInPagingFiles=data[1].value;			
			$scope.freeVirtualMemory = data[2].value;
			$scope.maxNumberOfProcesses = data[3].value
			$scope.maxProcessMemorySize = data[4].value
			$scope.numberOfProcesses = data[5].value;
			$scope.sizeStoredInPagingFiles = data[6].value;
			$scope.totalVirtualMemorySize=data[7].value;
			$scope.totalVisibleMemorySize=data[8].value;
			$scope.$apply();
		
	});


}]);