package com.github.ivanshafran.sharedpreferencesmock

import com.github.ivanshafran.sharedpreferencesmock.internal.ContextMock
import com.github.ivanshafran.sharedpreferencesmock.internal.SPContextWrapperMock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class SPMockBuilderTest : Spek({
    describe("SPMockBuilder") {
        val mockBuilder by memoized { SPMockBuilder() }

        context("on createSharedPreferences") {
            it("should return not null shared preference mock instance") {
                assertNotNull(mockBuilder.createSharedPreferences())
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
