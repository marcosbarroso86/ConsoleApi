var app = angular.module("app" , ["ngRoute"]);

app.config(function($routeProvider){

	$routeProvider
		.when("/cpu" , {
			templateUrl:"cpu.html",
			controller:"cpuController"
		})
		.when("/memoria" , {
			templateUrl:"memoria.html",
			controller:"memoriaController"
		})		
		.when("/general" , {
			templateUrl:"general.html",
			controller:"generalController"
		});

});

app.controller("mainController" , ["$scope", function($scope){

	$scope.checkbox;

	$scope.slide = function(){
		
		$scope.checkbox = false;
		
	}

}]);


