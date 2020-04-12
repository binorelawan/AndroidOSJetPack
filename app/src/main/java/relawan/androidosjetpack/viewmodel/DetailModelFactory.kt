package relawan.androidosjetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import relawan.androidosjetpack.model.AndroidOs

class DetailModelFactory (
    private val list: AndroidOs?,
    private val grid: AndroidOs?,
    private val card: AndroidOs?) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(list, grid, card) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}