package com.example.applicationtest.services

import android.util.Log
import com.example.applicationtest.models.Item
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ItemsRepository {
    fun provideItems(): Observable<List<Item>>? {
        val itemService: IItemsService = APIManager.getInstance().retrofit.create(IItemsService::class.java)
        return itemService.getItems()
            .flatMap { historic ->

                Log.d("*********", "check API request")

                Observable.just(historic)
            }
            .doOnError {
                Log.d("***************", it.message!!)
                Observable.just(null)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: ItemsRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: ItemsRepository().also { instance = it }
            }
    }
}