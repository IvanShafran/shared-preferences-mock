package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class SharedPreferencesDefaultValuesTest : Spek({

    describe("shared preferences mock") {
        context("no elements set") {

            val mock = SPMockBuilder().createSharedPreferences()

            it("should return default value for getString") {
                val defaultString = "default string"
                assertEquals(defaultString, mock.getString(null, defaultString))
            }

            it("should return default value for getStringSet") {
                val defaultStringSet = setOf("Some value")
                assertEquals(defaultStringSet, mock.getStringSet(null, defaultStringSet))
            }

            it("should return default value for getInt") {
                val defaultInt = 42
                assertEquals(defaultInt, mock.getInt(null, defaultInt))
            }

            it("should return default value for getLong") {
                val defaultLong = 42L
                assertEquals(defaultLong, mock.getLong(null, defaultLong))
            }

            it("should return default value for getFloat") {
                val defaultFloat = 42f
                assertEquals(defaultFloat, mock.getFloat(null, defaultFloat))
            }

            it("should return default value for getBoolean") {
                val defaultBoolean = true
                assertEquals(defaultBoolean, mock.getBoolean(null, defaultBoolean))
            }

            it("should return default value for getBoolean") {
                val defaultBoolean = true
                assertEquals(defaultBoolean, mock.getBoolean(null, defaultBoolean))
            }
        }
    }

})
