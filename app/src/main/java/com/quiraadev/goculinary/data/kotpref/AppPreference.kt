package com.quiraadev.goculinary.data.kotpref

import com.chibatching.kotpref.KotprefModel

object AppPreference : KotprefModel() {
    var darkMode by booleanPref(false)
}