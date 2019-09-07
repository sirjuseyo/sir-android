package com.sirjuseyo.lib.exceptions

import java.lang.Exception

class HangulJosaException(what: String) : Exception("JOSA[$what]")