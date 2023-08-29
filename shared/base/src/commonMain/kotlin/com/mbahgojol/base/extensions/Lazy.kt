package com.mbahgojol.base.extensions

inline fun <T> unsafeLazy(noinline initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)
