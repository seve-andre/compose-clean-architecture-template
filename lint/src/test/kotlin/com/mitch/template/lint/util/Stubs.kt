package com.mitch.template.lint.util

import com.android.tools.lint.checks.infrastructure.LintDetectorTest.kotlin
import com.android.tools.lint.checks.infrastructure.TestFile

val ComposableStub: TestFile = kotlin(
    """
    package androidx.compose.runtime
    annotation class Composable
    """
).indented()
