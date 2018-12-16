package com.kaloglu.sample.data.remote

abstract class NetworkProvider {
    abstract fun <S> create(serviceClass: Class<S>): S
}
