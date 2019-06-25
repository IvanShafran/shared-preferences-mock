package com.github.ivanshafran.sharedpreferencesmock

import android.content.SharedPreferences
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SharedPreferencesListenersTest : Spek({

    class ListenerMock : SharedPreferences.OnSharedPreferenceChangeListener {
        private var eventSharedPreferences: SharedPreferences? = null
        private var eventKey: String? = null
        private var isCalled = false
        override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
            eventSharedPreferences = sharedPreferences
            eventKey = key
            isCalled = true
        }

        fun assertSharedPreferences(instance: SharedPreferences?) {
            assertTrue { eventSharedPreferences === instance }
        }

        fun assertKey(key: String?) {
            assertEquals(eventKey, key)
        }

        fun assertNotCalled() {
            assertFalse(isCalled)
        }
    }

    val stringKey = "key"

    for (isThreadSafe in listOf(false, true)) {
        describe("shared preferences listeners with thread safety: $isThreadSafe") {
            val sharedPreferences by memoized {
                SPMockBuilder().setThreadSafe(isThreadSafe).createSharedPreferences()
            }
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

            context("register listener and remove string") {
                beforeEachTest {
                    sharedPreferences.edit().putString(stringKey, "").apply()
                    sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.edit().remove(stringKey).apply()
                }

                it("should call listener with string key and shared preferences instance") {
                    listener.assertKey(stringKey)
                    listener.assertSharedPreferences(sharedPreferences)
                }
            }

            context("register listener and clear all") {
                beforeEachTest {
                    sharedPreferences.edit().putString(stringKey, "").apply()
                    sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.edit().clear().apply()
                }

                it("should not call listener") {
                    // ?: see original implementation
                    // https://android.googlesource.com/platform/frameworks/base/+/refs/heads/master/core/java/android/app/SharedPreferencesImpl.java#498
                    listener.assertNotCalled()
                }
            }

            context("register and then unregister listener and put string") {
                beforeEachTest {
                    sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.edit().putString(stringKey, "").apply()
                }

                it("should not call listener") {
                    listener.assertNotCalled()
                }
            }

            context("register and remove nonexistent item") {
                beforeEachTest {
                    sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.edit().remove(stringKey).apply()
                }

                it("should not call listener") {
                    listener.assertNotCalled()
                }
            }

            context("register and put the same existing item") {
                beforeEachTest {
                    sharedPreferences.edit().putString(stringKey, "").apply()
                    sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.edit().putString(stringKey, "").apply()
                }

                it("should not call listener") {
                    listener.assertNotCalled()
                }
            }

            context("register and put new value to the existing item") {
                beforeEachTest {
                    sharedPreferences.edit().putString(stringKey, "old").apply()
                    sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
                    sharedPreferences.edit().putString(stringKey, "new").apply()
                }

                it("should call listener with string key and shared preferences instance") {
                    listener.assertKey(stringKey)
                    listener.assertSharedPreferences(sharedPreferences)
                }
            }
        }
    }
})
