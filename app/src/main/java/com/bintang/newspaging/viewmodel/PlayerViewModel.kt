package com.bintang.newspaging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bintang.newspaging.model.DataItem
import com.bintang.newspaging.repository.Repository
import kotlinx.coroutines.flow.Flow

class PlayerViewModel: ViewModel() {
    val repo = Repository()
    var responsePlayer : Flow<PagingData<DataItem>>? = null

    fun setPlayer(){
        responsePlayer = repo.getPlayer().cachedIn(viewModelScope)
    }
    fun getPlayer() = responsePlayer
}