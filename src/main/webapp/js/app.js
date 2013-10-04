angular.module('suicidal-app', ['ui.bootstrap', 'ngAnimate']);

var DetailCtrl = function ($scope, $http) {
	  $scope.checked = 0;
	  $scope.showResponse = 0;
	  $scope.serverResponse = "";
	  $scope.makeRequest = function() {
		  $http.get("/service")
		    .success(function(data,status) {
		    	$scope.serverResponse = data;
		    	if($scope.showResponse == 0) $scope.showResponse = 1; 
		    })
		    .error(function(data,status){
		    	alert("Error " + status + "!\n" + data)
		    });
	  }
	  $scope.killInstance = function() {
		  $http.get("/service/die");
	  }
	  $scope.filterComplex = function(items) {
		  var result = {};
		  angular.forEach(items, function(value, key) {
			  if(key != 'VCAP_APPLICATION') {
				  result[key] = value;
			  }
		  });
		  return result;
	  }
}
