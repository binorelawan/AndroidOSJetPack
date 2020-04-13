package relawan.androidosjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import relawan.androidosjetpack.model.AndroidOs

class DetailViewModel(androidOs: AndroidOs?) : ViewModel(){

    private val _androidName = MutableLiveData<Int>()
    val androidName: LiveData<Int>
        get() = _androidName

    private val _androidRemarks = MutableLiveData<Int>()
    val androidRemarks: LiveData<Int>
        get() = _androidRemarks

    private val _androidImage = MutableLiveData<Int>()
    val androidImage: LiveData<Int>
        get() = _androidImage

    private val _androidDetail = MutableLiveData<Int>()
    val androidDetail: LiveData<Int>
        get() = _androidDetail

    init {
        _androidName.value = androidOs?.name
        _androidRemarks.value = androidOs?.remarks
        _androidImage.value = androidOs?.photo
        _androidDetail.value = androidOs?.detail
    }
}