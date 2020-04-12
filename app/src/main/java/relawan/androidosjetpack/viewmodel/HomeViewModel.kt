package relawan.androidosjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // mode list
    private val _modeList = MutableLiveData<String>()
    val modeList: LiveData<String>
        get() = _modeList

    // mode grid
    private val _modeGrid = MutableLiveData<String>()
    val modeGrid: LiveData<String>
        get() = _modeGrid

    // mode card

    private val _modeCard = MutableLiveData<String>()
    val modeCard: LiveData<String>
        get() = _modeCard

    init {
        _modeList.value = "Mode List"
        _modeGrid.value = "Mode Grid"
        _modeCard.value = "Mode Card"
    }

}