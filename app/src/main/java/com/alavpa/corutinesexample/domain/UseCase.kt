package com.alavpa.corutinesexample.domain

abstract class UseCase<out Type, in Params> {
    internal abstract fun run(params: Params?): Either<Type, Error>
}
