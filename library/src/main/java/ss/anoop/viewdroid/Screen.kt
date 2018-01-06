package com.eagle.gkpedia.monitor.ui.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View

/**
 * Created by anoopss on 23/11/17.
 */
open abstract class Screen {

    private lateinit var view : View

    fun getView() = view

    fun createView(context: Context?){
        view = LayoutInflater.from(context).inflate(getLayout(), null)

        onViewCreated(view)
    }

    abstract fun getLayout() : Int

    open fun onViewCreated(v : View){}

    open fun destroy(){}

    open fun handleBack()  = false
}