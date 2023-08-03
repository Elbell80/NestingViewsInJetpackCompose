package com.elina.samplecodelabjc.ui.screen.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.elina.samplecodelabjc.ui.screen.CollapsingToolbarScreen
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme

/**
 * Created by Elina on 06/07/2023.
 */

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleCodeLabJCTheme {
               // CollapsingToolbarScreen()
            }
        }
    }
}
