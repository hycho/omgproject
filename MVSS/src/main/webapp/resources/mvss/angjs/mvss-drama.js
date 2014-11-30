var dramaViewModule = angular.module('mvss-drama-view-app', ['ui.bootstrap']);

dramaViewModule.controller('ViewSlideCtl', ['$scope', function ($scope) {
	$scope.rate = 2;
	  $scope.max = 5;
	  $scope.isReadonly = true;
	  
}]);