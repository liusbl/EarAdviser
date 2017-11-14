package lt.liusbl.earadviser.landing

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lt.liusbl.earadviser.training.TrainingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(TrainingActivity.newInstance(this))
        finish()
    }
}
