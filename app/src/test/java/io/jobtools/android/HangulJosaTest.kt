package io.jobtools.android

import io.jobtools.android.exceptions.HangulJosaException
import io.jobtools.android.hangul.concatJosa
import org.junit.Assert.assertEquals
import org.junit.Test

class HangulJosaTest {

    @Test(expected = HangulJosaException::class)
    fun josaExceptionOnNoHangul() {
        "ABC".concatJosa("을")
    }

    @Test
    fun josa사람을() {
        assertEquals("사람을", "사람".concatJosa("을"))
        assertEquals("사람을", "사람".concatJosa("를"))
    }

    @Test
    fun josa동기화를() {
        assertEquals("동기화를", "동기화".concatJosa("을"))
        assertEquals("동기화를", "동기화".concatJosa("를"))
    }

    @Test
    fun josa사람이() {
        assertEquals("사람이", "사람".concatJosa("이"))
        assertEquals("사람이", "사람".concatJosa("가"))
    }

    @Test
    fun josa동기화가() {
        assertEquals("동기화가", "동기화".concatJosa("이"))
        assertEquals("동기화가", "동기화".concatJosa("가"))
    }

    @Test
    fun josa사람은() {
        assertEquals("사람은", "사람".concatJosa("은"))
        assertEquals("사람은", "사람".concatJosa("는"))
    }

    @Test
    fun josa동기화는() {
        assertEquals("동기화는", "동기화".concatJosa("은"))
        assertEquals("동기화는", "동기화".concatJosa("는"))
    }

    @Test
    fun josa사람과() {
        assertEquals("사람과", "사람".concatJosa("과"))
        assertEquals("사람과", "사람".concatJosa("와"))
    }

    @Test
    fun josa동기화와() {
        assertEquals("동기화와", "동기화".concatJosa("과"))
        assertEquals("동기화와", "동기화".concatJosa("와"))
    }

    @Test
    fun josa사람으로() {
        assertEquals("사람으로", "사람".concatJosa("으로"))
        assertEquals("사람으로", "사람".concatJosa("로"))
    }

    @Test
    fun josa동기화로() {
        assertEquals("동기화로", "동기화".concatJosa("으로"))
        assertEquals("동기화로", "동기화".concatJosa("로"))
    }

    @Test
    fun josa사람아() {
        assertEquals("사람아", "사람".concatJosa("아"))
        assertEquals("사람아", "사람".concatJosa("야"))
    }

    @Test
    fun josa동기화야() {
        assertEquals("동기화야", "동기화".concatJosa("아"))
        assertEquals("동기화야", "동기화".concatJosa("야"))
    }

    @Test
    fun josa사람이랑() {
        assertEquals("사람이랑", "사람".concatJosa("이랑"))
        assertEquals("사람이랑", "사람".concatJosa("랑"))
    }

    @Test
    fun josa동기화랑() {
        assertEquals("동기화랑", "동기화".concatJosa("이랑"))
        assertEquals("동기화랑", "동기화".concatJosa("랑"))
    }

}