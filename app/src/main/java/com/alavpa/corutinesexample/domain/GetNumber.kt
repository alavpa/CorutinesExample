package com.alavpa.corutinesexample.domain

class GetNumber : UseCase<String, Nothing>() {

    override fun run(params: Nothing?): Either<String, Error> {

        Thread.sleep(5000)
        val either = GetNumberParams().run(GetNumberParams.Params(12))

        return when(either){
            is Either.Success -> {
               Either.Success("getNumber ${either.success + 10}")
            }
            is Either.Failure -> {
                Either.Failure(either.error)
            }
        }
    }

}
