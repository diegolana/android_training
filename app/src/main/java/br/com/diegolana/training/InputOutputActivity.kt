package br.com.diegolana.training

import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.diegolana.training.databinding.ActivityMainBinding
import kotlin.concurrent.thread


class InputOutputActivity : AppCompatActivity() {

    private lateinit var viewModel: InputOutputViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InputOutputViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setup()
    }

    private fun setup() {
        viewModel.outputData.observe(this, Observer {
            binding.scrollview.fullScroll(View.FOCUS_DOWN)
        })

        binding.inputEditText.let {
            viewModel.isInputEnabled.postValue(false)
            it.setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    val input = it.text.toString()
                    it.text.clear()
                    viewModel.setLastInput(input)
                    true
                } else {
                    false
                }
            }
        }

        thread {
            TrainingCode(viewModel).main()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuClear -> viewModel.clear()
            R.id.menuReplay -> restart()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun restart() {
        val intent = intent
        finish()
        startActivity(intent)
    }

}