package com.sample.app.infrastructure.adapters

interface BindableListAdapter<T> {
    fun submitList(list: T?)
}