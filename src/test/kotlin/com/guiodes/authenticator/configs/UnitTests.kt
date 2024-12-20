package com.guiodes.authenticator.configs

import io.mockk.clearAllMocks
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
abstract class UnitTests {

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }
}
