var homeModule = angular.module('mvss-home-app', ['commonApp']);

homeModule.controller('MainSlideCtl', ['$scope', '$log', '$http', function ($scope, $log, $http) {
	// main slide 모델 데이터
	$scope.mainSlides = [];
	
	// open repeat modal
	$scope.selectBest5BroadCast = function () {
		$http.post(contextPath + "/selectBest5BroadCast", null, {
		}).success(function(response, status){
			$scope.mainSlides = response.data;
			setTimeout(function() {
			    $scope.$apply(function(){
			    	flexSlideInit();
			    },1);
			});
			
		}).error(function(data, status){
			console.log(data);
			console.log(status);
		});
	};
	
	var flexSlideInit = function() {
		$('.flexslider').flexslider({
			animation: "slide",
		    animationSpeed: 1500,
		    start: function(slider){
		    	$('body').removeClass('loading');
		    }
		});
	};
	
	angular.element(document).ready(function () {
		$scope.selectBest5BroadCast();
	});
	
}]);

homeModule.controller('MainBest8DramaCtl', ['$scope', '$log', '$http', function ($scope, $log, $http) {
	$scope.best8Drama = [];
	
	$scope.selectBest8Drama = function () {
		$http.post(contextPath + "/drama/selectBest8Drama", null, {
		}).success(function(response, status){
			$scope.best8Drama = response;
			setTimeout(function() {
			    $scope.$apply(function(){
			    },1);
			});
		}).error(function(data, status){
			console.log(data);
			console.log(status);
		});
	};
	
	angular.element(document).ready(function () {
		$scope.selectBest8Drama();
	});
}]);
