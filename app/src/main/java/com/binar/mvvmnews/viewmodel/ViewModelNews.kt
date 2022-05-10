package com.binar.mvvmnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.mvvmnews.model.GetAllNewsResponse
import com.binar.mvvmnews.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel() {
    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsResponse>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLiveDataNews2() : MutableLiveData<List<GetAllNewsResponse>>{
        return liveDataNews
    }

    fun getDataNews(){
        APIClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsResponse>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsResponse>>,
                    response: Response<List<GetAllNewsResponse>>
                ) {
                    if (response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsResponse>>, t: Throwable) {
                    liveDataNews.postValue(null)

                }

            })
    }
}