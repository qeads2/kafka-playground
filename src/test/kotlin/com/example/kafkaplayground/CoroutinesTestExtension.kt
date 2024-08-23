package com.example.kafkaplayground

import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestInstancePostProcessor
import kotlin.let

@ExperimentalCoroutinesApi
class CoroutinesTestExtension :
    TestInstancePostProcessor,
    BeforeAllCallback,
    AfterAllCallback {
    private val dispatcher = UnconfinedTestDispatcher()
    private var testScope = TestScope(dispatcher)

    override fun postProcessTestInstance(
        p0: Any?,
        p1: ExtensionContext?,
    ) {
        (p0 as CoroutineTest).let {
            it.testScope = testScope
        }
    }

    override fun beforeAll(p0: ExtensionContext?) {
        Dispatchers.setMain(dispatcher)
    }

    override fun afterAll(p0: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}
