package com.sirjuseyo.lib.type

import com.sirjuseyo.lib.util.GsonHelper
import java.io.Serializable

open class JsonElementAs(val obj: Any, val outputType: OutputType) : Serializable {
    fun <T> get(): T = obj as T

    override fun toString() = GsonHelper.toJson(obj)
}
