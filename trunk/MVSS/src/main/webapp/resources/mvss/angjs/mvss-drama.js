var dramaViewModule = angular.module('mvss-drama-view-app', ['ui.bootstrap']);

dramaViewModule.controller('ViewSlideCtl', ['$scope', function ($scope) {
	$scope.rate = 7;
	  $scope.max = 10;
	  $scope.isReadonly = true;
	  
}]);