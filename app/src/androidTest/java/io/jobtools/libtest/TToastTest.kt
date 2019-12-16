package io.jobtools.libtest

import io.jobtools.android.TToast
import io.jobtools.android.demo.R
import org.junit.Before
import org.junit.Test

class TToastTest {

    @Before
    fun reset(){
        TToast.unSetCustomView()
    }

    @Test
    fun show() {

        TToast.setCustomView(
            R.layout.view_toast,
            R.id.textToastMessage
        )

        TToast.show("HELLO TOAST1")

        Thread.sleep(4000)
    }


    @Test
    fun show2() {
        TToast.show("HELLO TOAST2")

        Thread.sleep(4000)
    }
}