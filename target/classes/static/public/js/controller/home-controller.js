angular.module('main').controller('homeController',function ($scope, $http, $location, $rootScope){
	
	$scope.pedido = {};
	$scope.notas = [];
	
	$scope.save = function(){
		$http.post('/pedido/nota',$scope.pedido)
		.success(function(pedido){
			$scope.notas.push(pedido);
		})
		.catch(function(error){
			console.log(error);
		});
	}
});