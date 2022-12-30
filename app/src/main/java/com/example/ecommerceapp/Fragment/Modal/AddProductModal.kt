package com.example.ecommerceapp.Fragment.Modal

data class AddProductModal(
    val productName : String? = "",
    val productDescription : String? = "",
    val productCoverImg : String? = "",
    val productCategory : String? = "",
    val productId : String? = "",
    val productMrp : String? = "",
    val productSp : String? = "",
    val productImages : ArrayList<String> = ArrayList()

)
