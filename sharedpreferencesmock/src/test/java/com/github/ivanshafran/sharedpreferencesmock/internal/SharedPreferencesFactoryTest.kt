package com.github.ivanshafran.sharedpreferencesmock.internal

import android.content.SharedPreferences
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertTrue

class SharedPreferencesFactoryTest : Spek({

    describe("shared preferences factory") {
        lateinit var preferences: SharedPreferences

        context("thread safe flag is enabled") {
            beforeEachTest {
                preferences = SharedPreferencesFactory(true).create()
            }

            it("should create thread safe preferences instance") {
                assertTrue { preferences is ThreadSafeSharedPreferencesMock }
            }
        }

        context("thread safe flag is disabled") {
            beforeEachTest {
                preferences = SharedPreferencesFactory(false).create()
            }

            it("should create not thread safe preferences instance") {
                assertTrue { preferences is SharedPreferencesMock }
            }
        }
    }

})
