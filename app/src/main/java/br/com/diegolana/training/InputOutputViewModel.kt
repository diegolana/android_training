package br.com.diegolana.training

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class InputOutputViewModel(application: Application) : AndroidViewModel(application),
    InterfaceInputOutput {

    private var lastInput = ""
    private var outputText = ""
    val isInputEnabled: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val outputData: MutableLiveData<String> = MutableLiveData<String>("")

    override fun write(msg: String) {
        outputText = "$outputText$msg"
        updateText()
    }

    override fun writeln(msg: String) {
        write("$msg\n")
    }

    override fun clear() {
        outputText = ""
        updateText()
    }

    override fun read(message: String?): String {
        write("\n> $message")

        var returnInput = ""

        isInputEnabled.postValue(true)
        while (lastInput.isEmpty()) {
            Thread.sleep(50)
            returnInput = lastInput
        }
        isInputEnabled.postValue(false)

        writeln(" $returnInput")
        lastInput = ""

        return returnInput
    }

    private fun updateText() {
        outputData.postValue(outputText)
    }

    fun setLastInput(input: String) {
        lastInput = input
    }

}