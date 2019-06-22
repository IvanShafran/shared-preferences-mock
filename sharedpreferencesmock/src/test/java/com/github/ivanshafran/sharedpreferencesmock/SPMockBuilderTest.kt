package com.github.ivanshafran.sharedpreferencesmock

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertTrue

class SPMockBuilderTest : Spek({
    describe("SPMockBuilder") {
        val mockBuilder = SPMockBuilder()

        context("on createSharedPreferences") {
            it("should return shared preference mock instance") {
                assertTrue { mockBuilder.createSharedPreferences() is SharedPreferencesMock }
            }
        }

        context("on createContext") {
            it("should return context wrapper mock instance") {
                assertTrue { mockBuilder.createContext() is SPContextWrapperMock }
            }
        }

        context("on wrapContext") {
            it("should return context wrapper mock instance") {
                assertTrue { mockBuilder.wrapContext(ContextMock()) is SPContextWrapperMock }
            }
        }
    }
})
