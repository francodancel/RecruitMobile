package com.sample.app.infrastructure.listeners

interface ItemSelectedListener<T> {
    fun onItemSelected(item: T)
}