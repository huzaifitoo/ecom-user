package com.example.ecommerceapp.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.google.common.net.HttpHeaders.FROM


@Dao
interface ProductDao {
    @Insert
   suspend fun insertProduct (product : ProductModel)
    @Delete
    suspend fun deleteProduct(product : ProductModel)
    @Query("SELECT * FROM products")
    fun getAllProducts() : LiveData<List<ProductModel>>
    @Query("SELECT * FROM products WHERE productId = :id")
    fun isExit(id : String) : ProductModel
}