package ss.anoop.viewdroid.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ss.anoop.viewdroid.sample.R
import ss.anoop.viewdroid.Router
import ss.anoop.viewdroid.RouterTransaction
import ss.anoop.viewdroid.screens.OptionsListScreen

class MainActivity : AppCompatActivity() {

    private var router: Router? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == router) {
            router = Router.init(findViewById(R.id.screen_container))
        }

        router?.presentScreen(RouterTransaction().with(OptionsListScreen()))
    }

    override fun onBackPressed() {
        if(router?.handleBack() == false) {
            super.onBackPressed()
        }
    }
}
