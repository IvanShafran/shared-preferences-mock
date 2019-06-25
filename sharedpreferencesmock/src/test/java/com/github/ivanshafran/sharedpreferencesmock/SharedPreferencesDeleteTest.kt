package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SharedPreferencesDeleteTest : Spek({

    for (isThreadSafe in listOf(false, true)) {
        describe("deleting elements from shared preferences mock with thread safety: $isThreadSafe") {
            val sharedPreferences by memoized {
                SPMockBuilder().setThreadSafe(isThreadSafe).createSharedPreferences()
            }

            context("on calling clear in edit builder") {
                beforeEachTest {
                    sharedPreferences.edit().putInt("1", 1).putBoolean("2", false).commit()
                    sharedPreferences.edit().clear().commit()
                }

                it("should delete all items") {
                    assertTrue(sharedPreferences.all.isEmpty())
                }
            }

            context("on calling remove in edit builder") {
                beforeEachTest {
                    sharedPreferences.edit().putInt("1", 1).putBoolean("2", false).commit()
                    sharedPreferences.edit().remove("1").commit()
                }

                it("should remove only specific item") {
                    assertFalse(sharedPreferences.contains("1"))
                    assertTrue(sharedPreferences.contains("2"))
                }
            }
        }
    }

})
