package com.alavpa.corutinesexample.domain

sealed class Either<out T, R> {
    class Success<T, R>(val success: T) : Either<T, R>()
    class Failure<T, R>(val error: R) : Either<T, R>()
}
