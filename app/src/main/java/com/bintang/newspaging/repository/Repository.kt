package com.bintang.newspaging.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bintang.newspaging.datasource.PlayersDataSource
import com.bintang.newspaging.model.DataItem
import com.bintang.newspaging.network.ModelNetwork
import kotlinx.coroutines.flow.Flow


class Repository {
    val api = ModelNetwork.initService()

    fun getPlayer(): Flow<PagingData<DataItem>>{
        val pager = Pager(PagingConfig(pageSize = 10)){
            PlayersDataSource(api)
        }.flow

        return pager
    }
}