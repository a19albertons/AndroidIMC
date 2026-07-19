package com.example.androidimc.fragmentos

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidimc.ImcCalculatorFragment
import com.example.androidimc.R
import com.example.androidimc.ResultIMCFragment
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Prueba para inflar el fragmento ImcCalculatorFragment.
 */
@RunWith(AndroidJUnit4::class)
class InflarFragmentos {
    val fragmentArgsResultIMCFragment =
        Bundle().apply {
            putInt("altura", 170)
            putInt("peso", 70)
            putInt("edad", 25)
        }

    // Prueba para inflar el fragmento ImcCalculatorFragment
    @Test
    fun inflarImcCalculatorFragment() {
        val scenario = launchFragmentInContainer<ImcCalculatorFragment>(themeResId = R.style.Theme_AndroidIMC)
        scenario.onFragment { fragment ->
            assertNotNull(fragment.view)
        }
    }

    @Test
    fun inflarResultIMCFragment() {
        val scenario =
            launchFragmentInContainer<ResultIMCFragment>(
                themeResId = R.style.Theme_AndroidIMC,
                fragmentArgs = fragmentArgsResultIMCFragment,
            )
        scenario.onFragment { fragment ->
            assertNotNull(fragment.view)
        }
    }
}
