package com.example.applicationtest.services

import com.example.applicationtest.models.Item
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IItemsService {

    @GET("api/Items/{id}")
    fun getItemById(@Path("id") id: String) : Observable<Item>

    @GET("api/Items")
    fun getItems() : Observable<List<Item>>
}