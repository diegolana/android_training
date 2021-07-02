package br.com.diegolana.training

interface InterfaceInputOutput {

    fun write(msg: String)
    fun writeln(msg: String)
    fun clear()
    fun read(message: String?): String

}