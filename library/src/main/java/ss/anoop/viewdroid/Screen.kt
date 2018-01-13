package ss.anoop.viewdroid

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

/**
 * Created by anoopss on 23/11/17.
 *
 * This serves like a Fragment, but without any complex lifecycle. Any dynamic view that has to be loaded into the activity as a separate screen should be child of this class
 *
 */
abstract class Screen {

    private var bundle : Bundle? = null

    private val invalidLayoutRes = 0

    private lateinit var activity: Activity

    /**
     * Holds the reference to the actual view of the screen. It will be initialized only when a screen is presented in screen using @link{Router} methods. @see Screen#onCreateView()
     */
    private lateinit var view : View

    private lateinit var router: Router

    constructor(bundle: Bundle?){
        this.bundle= bundle
    }

    constructor()

    /**
     * @return inflated view
     */
    fun getView() = view

    /**
     * Inflates the screens view that is provides through the method @link{#getLayout()}
     */
    fun createView(context: Context?){

        if(invalidLayoutRes == getLayout()){
            throw IllegalArgumentException("Layout resource provided through getLayout() should be a valid one")
        }

        if(null == context){
            throw IllegalArgumentException("Context should'nt be null")
        }

        activity = context as Activity

        view = LayoutInflater.from(context).inflate(getLayout(), null)

        onViewCreated(view)
    }

    /**
     * Child classes should return the layout resource they want to display when presented
     *
     * @return layout resource of format R.layout.whatever_layout
     */
    abstract fun getLayout() : Int

    fun getRouter() = router

    fun setRouter(router: Router){
        this.router = router
    }

    fun getArgs() = bundle

    fun getActivity() = activity

    fun exit() = getRouter().pop()

    open fun onViewCreated(v : View){}

    open fun onScreenResume() {}

    open fun destroy(){}

    open fun handleBack()  = false
}