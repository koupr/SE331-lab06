'use strict'
var productService = angular.module('productServices',['ngResource']);

productService.factory('productService',function($resource){
    return $resource('/product/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

productService.service('totalCalService',function() {
    this.getTotalNetPrice = function (products) {
        var output = 0.0;

        for (var index = 0; index < products.length;index++) {
            var product = products[index];
            output += parseFloat(product.netPrice);
        }
        return output;
    }
})

productService.service('totalVatService',function(){
    this.getTotalVat = function(products){
        var output=0.0;

        for(var index = 0; index < products.length;index++) {
            var product2 = products[index];
            output += parseFloat(product2.totalVat);
        }
        return output;
    }
})