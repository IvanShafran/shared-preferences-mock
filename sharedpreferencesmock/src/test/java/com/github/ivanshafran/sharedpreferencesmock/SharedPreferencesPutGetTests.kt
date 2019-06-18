package com.github.ivanshafran.sharedpreferencesmock

import android.content.SharedPreferences
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class SharedPreferencesPutGetTests : Spek({

    // TEST DATA

    val stringKey = "string key"
    val stringValue = "string value"

    val stringSetKey = "string set key"
    val stringSetValue = setOf("first", "second", "third")

    val intKey = "int key"
    val intValue = 42

    val longKey = "long key"
    val longValue = 42L

    val floatKey = "float key"
    val floatValue = 42f

    val booleanKey = "boolean key"
    val booleanValue = true

    fun putAllTypes(sharedPreferences: SharedPreferences) {
        sharedPreferences
                .edit()
                .putString(stringKey, stringValue)
                .putStringSet(stringSetKey, stringSetValue)
                .putInt(intKey, intValue)
                .putLong(longKey, longValue)
                .putFloat(floatKey, floatValue)
                .putBoolean(booleanKey, booleanValue)
                .commit()
    }

    // TEST

    describe("shared preferences mock") {
        context("put values for each type via edit and commit") {
            val mock = SPMockBuilder().createSharedPreferences()
            putAllTypes(mock)

            it("should return correct string by key") {
                assertEquals(stringValue, mock.getString(stringKey, "default"))
            }

            it("should return correct string set by key") {
                assertEquals(stringSetValue, mock.getStringSet(stringSetKey, setOf()))
            }

            it("should return correct int by key") {
                assertEquals(intValue, mock.getInt(intKey, 0))
            }

            it("should return correct long by key") {
                assertEquals(longValue, mock.getLong(longKey, 0L))
            }

            it("should return correct float by key") {
                assertEquals(floatValue, mock.getFloat(floatKey, 0f))
            }

            it("should return correct boolean by key") {
                assertEquals(booleanValue, mock.getBoolean(booleanKey, true))
            }
        }
    }

})
