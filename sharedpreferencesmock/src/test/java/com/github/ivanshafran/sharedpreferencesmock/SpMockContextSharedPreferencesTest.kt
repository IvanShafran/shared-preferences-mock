package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertTrue

class SpMockContextSharedPreferencesTest : Spek({

    describe("context mock") {
        var context = SPMockContext()

        beforeEachTest {
            context = SPMockContext()
        }

        context("on first preferences request") {

            it("should return non null value of SharedPreferencesMock") {
                assertTrue { context.getSharedPreferences("", 0) is SharedPreferencesMock }
            }
        }

        context("on several request with the same name") {

            it("should return the same instance") {
                assertTrue { context.getSharedPreferences("", 0) === context.getSharedPreferences("", 0) }
            }
        }

        context("on several request with different names") {

            it("should return different instances") {
                assertTrue { context.getSharedPreferences("1", 0) !== context.getSharedPreferences("2", 0) }
            }
        }

        context("after preferences is deleted") {

            context("on the same preference request") {
                val first = context.getSharedPreferences("", 0)
                context.deleteSharedPreferences("")
                val second = context.getSharedPreferences("", 0)

                it("should return new instance") {
                    assertTrue { first !== second }
                }
            }
        }
    }

})
