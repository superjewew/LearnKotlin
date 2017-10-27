package com.proandroiddev.normanlie.learnkotlin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by Norman Lie on 10/11/2017.
 */
class MainViewModel : ViewModel() {
    var repoModel : RepoModel = RepoModel()
    val text = ObservableField("Old data")
    val isLoading = ObservableField(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : RepoModel.OnRepositoriesReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}