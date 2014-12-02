var homeModule = angular.module('mvss-home-app', []);

homeModule.controller('MainSlideCtl', ['$scope', '$log', '$http', '$location', function ($scope, $log, $http, $location) {
	// main slide 모델 데이터
	$scope.mainSlides = [];
	
	// open repeat modal
	$scope.selectBest5BroadCast = function () {
		$http.post(contextPath + "/selectBest5BroadCast", null, {
		}).success(function(response, status){
			$scope.mainSlides = response.data;
			$scope.$apply();
			flexSlideInit();
		}).error(function(data, status){
			console.log(data);
			console.log(status);
		});
	};
	
	$scope.init = function () {
		$scope.selectBest5BroadCast();
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
	
}]);