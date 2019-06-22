package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertFalse

class SPMockBuilderTest : Spek({
    describe("SPMockBuilder") {
        context("calling createSharedPreferences two times") {
            val builder = SPMockBuilder()
            val first = builder.createSharedPreferences()
            val second = builder.createSharedPreferences()

            it("should create new instance every time") {
                assertFalse { first === second }
            }
        }

        context("calling createContext two times") {
            val builder = SPMockBuilder()
            val first = builder.createContext()
            val second = builder.createContext()

            it("should create new instance every time") {
                assertFalse { first === second }
            }
        }
    }
})
