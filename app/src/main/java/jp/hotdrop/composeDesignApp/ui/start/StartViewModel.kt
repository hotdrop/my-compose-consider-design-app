package jp.hotdrop.composeDesignApp.ui.start

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : ViewModel() {
    private val _inputNickNameState = MutableStateFlow("")
    val inputNickNameState = _inputNickNameState.asStateFlow()

    private val _inputEmailState = MutableStateFlow("")
    val inputEmailState = _inputEmailState.asStateFlow()
    fun inputNickName(newVal: String) {
        _inputNickNameState.value = newVal
    }

    fun inputEmail(newVal: String) {
        _inputEmailState.value = newVal
    }

    fun save() {
        // TOOD 入力したニックネームとメールアドレスでユーザー登録する
    }
}