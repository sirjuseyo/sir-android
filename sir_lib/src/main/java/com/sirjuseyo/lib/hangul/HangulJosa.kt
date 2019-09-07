package com.sirjuseyo.lib.hangul

import com.sirjuseyo.lib.exceptions.HangulJosaException

object HangulJosa {

    /**
     * 초성, 중성, 종성의 위치를 int[]로 반환 한다.
     * @param c : 한글 한 글자
     * @return int[] : 한글 초, 중, 종성의 위치( ex:가 0,0,0 )
     */
    private fun split(c: Char): IntArray {
        val sub = IntArray(3)
        sub[0] = (c.toInt() - 0xAC00) / (21 * 28) //초성의 위치
        sub[1] = (c.toInt() - 0xAC00) % (21 * 28) / 28 //중성의 위치
        sub[2] = (c.toInt() - 0xAC00) % 28//종성의 위치
        return sub
    }

    /**
     * 한글의 종성 여부를 판단
     * @param hanAllElement
     * @return
     */
    private fun hasJongSung(char: Char): Boolean {
        val hanAllElement = split(char)
        return hanAllElement[2] > 0
    }

    /**
     * 한글 여부를 판단
     * @param char
     * @return
     */
    fun isHangul(char: Char): Boolean {
        return char.toInt() in 0xAC00..0xD7AF
    }

    /**
     * 주어형 (~~이, ~~가)
     * @param str
     * @return
     */
    fun getIga(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "이" else "가"
    }

    /**
     * 묘사형 (~~은, ~~는)
     * @param str
     * @return
     */
    fun getDesc(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "은" else "는"
    }

    /**
     * 대칭(-_-?)형 (~~와, ~~과)
     * @param str
     * @return
     */
    fun getAnd(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "과" else "와"
    }

    /**
     * 목적형 (~~을, ~~를)
     * @param str
     * @return
     */
    fun getObj(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "을" else "를"
    }

    /**
     * 물건따위 사용할때 형;; (~~으로, ~~로)
     * @param str
     * @return
     */
    fun getTool(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "으로" else "로"
    }

    /**
     * 주로 사람이름에 사용되는.. 인칭(?) 형
     * @param str
     * @return
     */
    fun getMe(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "이" else ""
    }

    /**
     * 호칭, ~아, ~야
     * @date 2014/05
     * @author park
     */
    fun getAYa(str: String): String {
        requireLastCharIsKorean(str)

        return if (lastCharHasJongSung(str)) "아" else "야"
    }

    fun combine(str: String, josa: String): String {
        requireLastCharIsKorean(str)

        listOf(
            "이|가",
            "은|는",
            "과|와",
            "을|를",
            "으로|로",
            "아|야",
            "이랑|랑"
        ).filter {
            josa.matches(it.toRegex())
        }
            .singleOrNull {
                val josaSet = it.split("|")
                return str +
                        if (lastCharHasJongSung(str))
                            josaSet.first()
                        else
                            josaSet.last()
            }

        return str + josa
    }

    private fun lastCharHasJongSung(str: String) = hasJongSung(str.last())

    private fun requireLastCharIsKorean(str: String) {
        if (str.isBlank() || !isHangul(str.last())) {
            throw HangulJosaException(str)
        }
    }
}

fun String.concatJosa(s: String): String {
    return HangulJosa.combine(this, s)
}