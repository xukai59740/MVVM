package com.mvvm.demo.view.common.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.CallSuper
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentResource())
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        setSupportActionBar(getActionToolbar())
        supportActionBar?.let(this::configureActionBar)
        initViews()
    }

    abstract fun getContentResource(): Int

    @CallSuper
    protected open fun initViews() = Unit

    protected open fun getActionToolbar(): Toolbar? = null

    protected open fun configureActionBar(actionBar: ActionBar) = Unit

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
