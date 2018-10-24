var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider
      .when('/home', { templateUrl: 'temp/home.html',
	  })
      .when('/about', { templateUrl: 'temp/aboutUs.html',
	  })
      .when('/contact', { templateUrl: 'temp/contact.html',
	  })                       
}]);

app.filter('genderFilter', [function () {
  return function (x) {
    var i;
     if (x.gender == "male") {
        return   "Mr."+ x.name;
      }
      else {
         return  "Mrs."+ x.name;
      }   
  };
}]);

app.controller('employeeCtrl', function($scope, $http) {

  $http.get("http://localhost:8081/employees").then(function (response) {
      $scope.employeeData = response.data;
      $scope.myTestData = [{ clientNo : '101' , clientName : 'JD'}]
      console.log("employeeData  "+$scope.employeeData);     
  });
 
  $scope.updateEmployee = function(updatedData){
    var updatedJson = {
      "employeeId": updatedData.employeeId,
      "name": updatedData.name,
      "task": updatedData.task,
      "assignedBy": updatedData.assignedBy,
      "status": updatedData.status,
      "gender": updatedData.gender
    }

  $http.put("http://localhost:8081/employee", updatedJson);
  }

  $scope.deleteEmployee = function(eId){
  $http.delete("http://localhost:8081/employee/" + eId).then(
    function(result) {
           // result is the item you changed
           $http.get('http://localhost:8081/employees').then(
                         function(response) {
                          $scope.employeeData = response.data;                      
        });
    });
 }
});



