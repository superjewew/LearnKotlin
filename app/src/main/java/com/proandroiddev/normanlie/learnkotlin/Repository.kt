package com.proandroiddev.normanlie.learnkotlin

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by Norman Lie on 10/11/2017.
 */
class Repository(repositoryName : String?, var repositoryOwner : String?,
                 var numberOfStars : Int?, var hasIssues : Boolean = false) : BaseObservable() {
    @get:Bindable
    var repositoryName : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.repositoryName)
    }
}