package com.proandroiddev.normanlie.learnkotlin

import android.os.Handler

/**
 * Created by Norman Lie on 10/11/2017.
 */

class RepoModel {

    fun getRepositories(onRepositoriesReadyCallback: OnRepositoriesReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100, false))
        arrayList.add(Repository("Second", "Owner 2", 30, false))
        arrayList.add(Repository("Third", "Owner 3", 430, false))

        Handler().postDelayed({onRepositoriesReadyCallback.onDataReady(arrayList)}, 2000)
    }

    interface OnRepositoriesReadyCallback {
        fun onDataReady(data : ArrayList<Repository>)
    }

}