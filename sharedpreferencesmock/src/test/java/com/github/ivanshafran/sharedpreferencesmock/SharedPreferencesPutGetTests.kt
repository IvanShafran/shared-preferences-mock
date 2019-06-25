package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SharedPreferencesPutGetTests : Spek({

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

    for (isThreadSafe in listOf(false, true)) {
        describe("shared preferences mock with thread safety: $isThreadSafe") {

            val sharedPreferences by memoized(CachingMode.SCOPE) {
                SPMockBuilder().setThreadSafe(isThreadSafe).createSharedPreferences()
            }

            context("put values for each type via edit and commit") {
                beforeGroup {
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

                it("should return correct string by key") {
                    assertEquals(stringValue, sharedPreferences.getString(stringKey, "default"))
                }

                it("should return correct string set by key") {
                    assertEquals(stringSetValue, sharedPreferences.getStringSet(stringSetKey, setOf()))
                }

                it("should return correct int by key") {
                    assertEquals(intValue, sharedPreferences.getInt(intKey, 0))
                }

                it("should return correct long by key") {
                    assertEquals(longValue, sharedPreferences.getLong(longKey, 0L))
                }

                it("should return correct float by key") {
                    assertEquals(floatValue, sharedPreferences.getFloat(floatKey, 0f))
                }

                it("should return correct boolean by key") {
                    assertEquals(booleanValue, sharedPreferences.getBoolean(booleanKey, true))
                }

                it("should return map with all values") {
                    assertTrue { sharedPreferences.all.size == 6 }
                }

                it("should contains put key") {
                    assertTrue { sharedPreferences.contains(stringKey) }
                }
            }
        }
    }

})
