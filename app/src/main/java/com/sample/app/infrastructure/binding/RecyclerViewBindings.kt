package com.sample.app.infrastructure.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.infrastructure.adapters.BindableListAdapter

@BindingAdapter("items")
fun <T> setItems(view: RecyclerView, items: T?) {
    check(view.adapter != null) {
        "Binding \"app:items\" needs an adapter assigned to the RecyclerView"
    }

    check(view.adapter is BindableListAdapter<*>) {
        "Binding \"app:items\" is only applicable for a RecyclerView with an adapter" +
                " of type BindableListAdapter"
    }

    Log.d("RecyclerViewBinding", "setItems($view, $items)")
    (view.adapter as BindableListAdapter<T>).submitList(items)
}