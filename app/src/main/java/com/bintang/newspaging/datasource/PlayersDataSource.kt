package com.bintang.newspaging.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bintang.newspaging.model.ConfigApi
import com.bintang.newspaging.model.DataItem

class PlayersDataSource(val api: ConfigApi): PagingSource<Int, DataItem>(){
    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {

        return try {

            //dari current page
            val nextPage = params.key ?: 1

            val response = api.getPlayers(nextPage, params.loadSize)

            LoadResult.Page(
                    response.data,
                    prevKey = if (nextPage == 1)null else nextPage -1,
                    nextKey = if (nextPage == response.meta?.totalPages) null else nextPage + 1
            )
        }catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

}