(function(){
	"use strict";
	// controller creation
	angular.module("category")
		.factory("categoryService", function($scope, $http, $rootScope){
			
			// Fetching a list of categories
			var getCategories = function(){
				return $http.get("http://localhost:8080/Petshop-rest/category/getCategories").then(function(response){
					return response.data;
				});
			};
			
			return{
				getCategories : getCategories
			};
		});	
	
}());
