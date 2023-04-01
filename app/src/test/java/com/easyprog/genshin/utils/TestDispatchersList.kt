package com.easyprog.genshin.utils

import com.easyprog.genshin.DispatchersList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatchersList: DispatchersList {
    override fun io(): CoroutineDispatcher = UnconfinedTestDispatcher()

    override fun ui(): CoroutineDispatcher = StandardTestDispatcher()
}