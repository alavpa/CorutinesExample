package com.alavpa.corutinesexample.presentation

import android.util.Log
import com.alavpa.corutinesexample.domain.Either
import com.alavpa.corutinesexample.domain.Error
import com.alavpa.corutinesexample.domain.UseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.HandlerContext
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

internal fun <T, Params> UseCase<T, Params>.execute(
    params: Params? = null,
    onError: (Error) -> Unit = {},
    onSuccess: (T) -> Unit = {},
    backgroundThread: CommonPool = CommonPool,
    mainThread: HandlerContext = UI
) {

    val job = async(backgroundThread) {
        Log.d("BasePresenter", "job ${Thread.currentThread().name}")
        this@execute.run(params)
    }

    job.execute(onError, onSuccess, mainThread)
}

internal fun <T> Deferred<Either<T, Error>>.execute(
    onError: (Error) -> Unit = {},
    onSuccess: (T) -> Unit = {},
    mainThread: HandlerContext = UI) {

    launch(mainThread) {
        Log.d("BasePresenter", "launch ${Thread.currentThread().name}")
        val result = this@execute.await()

        when (result) {
            is Either.Success -> {
                onSuccess(result.success)
            }
            is Either.Failure -> {
                onError(result.error)
            }
        }
    }
}
