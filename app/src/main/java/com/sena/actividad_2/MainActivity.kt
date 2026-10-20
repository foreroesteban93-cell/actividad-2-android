
package com.sena.actividad_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.sena.actividad_2.ui.screen.Home
import com.sena.actividad_2.ui.theme.Actividad_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Actividad_2Theme {
                Surface {
                    Home()
                }
            }
        }
    }
}
