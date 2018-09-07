package com.alavpa.corutinesexample.domain

class GetNumberParams : UseCase<Int, GetNumberParams.Params>() {

    override fun run(params: Params?): Either<Int, Error> {
        Thread.sleep(5000)
        return Either.Success(params?.number ?: 0)
    }

    class Params(val number: Int)
}
