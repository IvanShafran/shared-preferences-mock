package com.github.ivanshafran.sharedpreferencesmock

import android.content.SharedPreferences
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SharedPreferencesListenersTest : Spek({

    class ListenerMock : SharedPreferences.OnSharedPreferenceChangeListener {
        private var eventSharedPreferences: SharedPreferences? = null
        private var eventKey: String? = null
        override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
            eventSharedPreferences = sharedPreferences
            eventKey = key
        }

        fun assertSharedPreferences(instance: SharedPreferences?) {
            assertTrue { eventSharedPreferences === instance }
        }

        fun assertKey(key: String?) {
            assertEquals(eventKey, key)
        }
    }

    val stringKey = "key"

    describe("shared preferences listeners") {
        val sharedPreferences by memoized { SPMockBuilder().createSharedPreferences() }
        val listener by memoized { ListenerMock() }

        context("register listener and put string") {
            beforeEachTest {
                sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                sharedPreferences.edit().putString(stringKey, "").apply()
            }

            it("should call listener with string key and shared preferences instance") {
                listener.assertKey(stringKey)
                listener.assertSharedPreferences(sharedPreferences)
            }
        }

        context("register and then unregister listener and put string") {
            beforeEachTest {
                sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
                sharedPreferences.edit().putString(stringKey, "").apply()
            }

            it("should not call listener") {
                listener.assertKey(null)
                listener.assertSharedPreferences(null)
            }
        }

    }

})
