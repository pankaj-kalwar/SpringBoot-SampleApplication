(function(){
	"use strict";
	// controller creation
	angular.module("category")
		.controller("categoryCtrl", function($scope, categoryService){
			$scope.categoryList = categoryService.getCategories;
		});	
	
}());
