package io.qameta.allure.android

import androidx.test.platform.app.InstrumentationRegistry
import io.qameta.allure.kotlin.AllureLifecycle
import io.qameta.allure.kotlin.FileSystemResultsWriter
import io.qameta.allure.kotlin.AllureResultsWriter
import io.qameta.allure.kotlin.util.PropertiesUtils
import java.io.File

open class AllureAndroidLifecycle(writer: AllureResultsWriter = FileSystemResultsWriter(::obtainResultsDirectory)) :
    AllureLifecycle(writer = writer)

/**
 * Obtains results directory as a [File] reference.
 * It takes into consideration the results directory specified via **allure.results.directory** property.
 */
private fun obtainResultsDirectory(): File {
    val defaultAllurePath = PropertiesUtils.resultsDirectoryPath
    return File(InstrumentationRegistry.getInstrumentation().targetContext.filesDir, defaultAllurePath)
}
