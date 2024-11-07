package com.example.virtualtourist.data.sources.local

import android.content.Context
import androidx.compose.ui.res.stringResource
import com.example.virtualtourist.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesService @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val sp = context.getSharedPreferences("VRT_SP", Context.MODE_PRIVATE)
    private val editor get() = sp.edit()

    fun getToken(): String? {
        return sp.getString(context.getString(R.string.sp_key_token), null)
    }

    fun putToken(value: String?) {
        editor.putString(context.getString(R.string.sp_key_token), value).apply()
    }
}