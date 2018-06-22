angular.module('main', ['ngRoute','ngResource'])
.config(function($routeProvider,$locationProvider) {
	
	 $routeProvider.when('/home', {
         templateUrl: 'public/partials/catho-home.html',
         controller: 'homeController'
     });
	 
	 $routeProvider.otherwise({redirectTo:'/home'});
})