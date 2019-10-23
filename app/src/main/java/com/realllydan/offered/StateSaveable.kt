package com.realllydan.offered

import android.os.Bundle

interface StateSaveable {

    /**
     * @param outState the state of the presenter is stored to this
     * */
    fun savePresenterState(outState: Bundle)

    /**
     * @param savedInstanceState the state of the presenter is restored froom this
     * */
    fun restorePresenterState(savedInstanceState: Bundle)
}