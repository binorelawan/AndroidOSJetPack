package relawan.androidosjetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import relawan.androidosjetpack.model.AndroidOs

class DetailModelFactory (
    private val androidOs: AndroidOs?) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(androidOs) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}