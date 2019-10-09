package com.mvvm.demo.data.authentication

import androidx.room.Dao
import androidx.room.Query
import com.mvvm.demo.data.common.room.BaseSimpleDao
import com.mvvm.demo.domain.authentication.entity.Account
import io.reactivex.Maybe

@Dao
interface AccountDao : BaseSimpleDao<Account> {

    @Query(
        """
        SELECT *
        FROM ${Account.TABLE_NAME}
        WHERE ${Account.COLUMN_ID} = :id
    """
    )
    override fun getItem(id: Long): Maybe<Account>

    @Query("DELETE FROM ${Account.TABLE_NAME}")
    override fun deleteAll()

}
