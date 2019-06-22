package com.github.ivanshafran.sharedpreferencesmock

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.lang.reflect.InvocationTargetException
import kotlin.reflect.KFunction
import kotlin.reflect.KVisibility
import kotlin.reflect.full.createType
import kotlin.reflect.full.functions
import kotlin.test.assertFailsWith

private val INT_TYPE = Int::class.createType()
private val ANY_FUNCTIONS = listOf(
        Context::equals,
        Context::hashCode,
        Context::toString
)

// For overload functions
private fun <Type> getFunctionReference(reference: Type): Type {
    return reference
}

private val CONTEXT_FINAL_FUNCTIONS = listOf(
        Context::getColorStateList,
        Context::getDrawable,
        getFunctionReference<Context.(Int) -> String>(Context::getString),
        getFunctionReference<Context.(Int, Array<Any>) -> String>(Context::getString),
        Context::getText,
        Context::getColor,
        getFunctionReference<Context.(IntArray) -> TypedArray>(Context::obtainStyledAttributes),
        getFunctionReference<Context.(Int, IntArray) -> TypedArray>(Context::obtainStyledAttributes),
        getFunctionReference<Context.(AttributeSet, IntArray) -> TypedArray>(Context::obtainStyledAttributes),
        getFunctionReference<Context.(AttributeSet, IntArray, Int, Int) -> TypedArray>(Context::obtainStyledAttributes),
        getFunctionReference<Context.(Class<Any>) -> Any>(Context::getSystemService)
)

class SPMockContextThrowsTest : Spek({

    val contextMock = ContextMock()
    val functions = Context::class.functions
            .filter { it.visibility == KVisibility.PUBLIC }
            .filter { it !in ANY_FUNCTIONS + CONTEXT_FINAL_FUNCTIONS }

    fun getCallArgumentMocks(function: KFunction<*>): Array<Any?> {
        return function.parameters
                .subList(1, function.parameters.size)
                .map {
                    when (it.type) {
                        INT_TYPE -> 0
                        else -> null
                    }
                }
                .toTypedArray()
    }

    fun rethrowInvocationTargetExceptionCause(block: () -> Unit) {
        try {
            block()
        } catch (e: InvocationTargetException) {
            throw e.cause ?: return
        }
    }

    describe("context mock") {

        functions.forEach { function ->
            context("on $function call") {
                it("should throw UnsupportedOperationException") {
                    assertFailsWith<UnsupportedOperationException> {
                        rethrowInvocationTargetExceptionCause {
                            val args = getCallArgumentMocks(function)
                            function.call(contextMock, *args)
                        }
                    }
                }
            }
        }
    }

})
