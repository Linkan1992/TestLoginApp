package a740362.testloginapp.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var context : Context

    lateinit var viewDataBinding: T
        private set

    var mViewModel: V? = null;

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val viewModel: V

    abstract val bindingVariable: Int

    abstract val customTitle: String

    abstract val toolbar: Toolbar?

    abstract fun initOnCreate(savedInstanceState: Bundle?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        initOnCreate(savedInstanceState)
        title = customTitle

    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mViewModel = mViewModel ?: viewModel
        viewDataBinding.setVariable(bindingVariable, mViewModel)
        viewDataBinding.executePendingBindings()
    }

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
