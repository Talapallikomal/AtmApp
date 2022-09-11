package com.example.atmapp.network


data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val responseCode: String? = ""
) {

    companion object {
        fun <T> success(data: T, message: String?): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, message = message)

        fun <T> error(data: T?, message: String, responseCode: String? = ""): Resource<T> =
            Resource(
                status = Status.ERROR,
                data = data,
                message = message,
                responseCode = responseCode
            )

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = Status.LOADING, data = data, message = null)
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}