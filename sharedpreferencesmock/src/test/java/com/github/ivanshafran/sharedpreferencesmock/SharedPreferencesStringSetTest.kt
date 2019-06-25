package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class SharedPreferencesStringSetTest : Spek({

    val key = "key"
    for (isThreadSafe in listOf(false, true)) {
        describe("string set processing in shared preferences with thread safety: $isThreadSafe") {
            val sharedPreferences by memoized {
                SPMockBuilder().setThreadSafe(isThreadSafe).createSharedPreferences()
            }

            context("on null string set") {
                beforeEachTest {
                    sharedPreferences.edit().putStringSet(key, null).commit()
                }

                it("should save and return null string set") {
                    assertNull(sharedPreferences.getStringSet(key, null))
                }
            }

            context("on nonnull string set") {
                val stringSet = setOf("1", "2")
                var returnedSet: Set<String>? = null
                beforeEachTest {
                    sharedPreferences.edit().putStringSet(key, stringSet).commit()
                    returnedSet = sharedPreferences.getStringSet(key, null)
                }

                it("should save and return copy of it") {
                    assertEquals(stringSet, returnedSet)
                    assertTrue { returnedSet !== stringSet }
                }
            }
        }
    }

})
