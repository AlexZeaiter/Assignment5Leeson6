package com.example.assignment4leason5

data class Product (
    var Title: String? = null,
    var price : Double? = null,
    var color: String? = null,
    var image // name of the image
            : String? = null,
    var itemid: String? = null,
    var desc // Description of the product
            : String? = null
)