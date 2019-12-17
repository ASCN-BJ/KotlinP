package com.bj.library


/**
 * Function:
 * Author  :@author BuJie
 * Date:2019/12/16
 */
class Option<T> {
    private constructor() {
        this.value = null
    }

    private constructor(t: T?) {
        this.value = t
    }

    private var value: T? = null

    companion object {
//        private val EMPTY: Option<*> = Option<Any>()

        fun <X> fromNullable(x: X?): Option<X> {
            return if (x == null) {
                empty()
            } else {
                Option(x)
            }
        }

        fun <X> empty(): Option<X> {
            return Option()
        }

    }

    fun getOrElse(action: () -> T): T {
        return value ?: action()
    }

    fun exists(action: () -> Boolean) {
        value ?: return
        action()
    }

    fun doCall(action: () -> Boolean, action1: () -> Unit) {
        if (action()) {
            return
        }
        action1()
    }
}