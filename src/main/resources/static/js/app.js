var app=angular.module("MyApp",[]);
app.controller("ProduitController",function($scope,$http){
	$scope.produits=null;

	$http.get("http://localhost:8080/produits")
		.then(function(response){
			$scope.produits=response.data;
			console.log(response.data);
		})
		.catch(function(err){
			console.log(err);
		})
	
	
});


