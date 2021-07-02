package br.com.diegolana.training

class TrainingCode(private val io: InterfaceInputOutput) {

    fun main() {

        io.write("Hello, World")
        io.writeln("!!!")

        val readName = io.read("Enter your name:")
        val readNumber = io.read("Enter a repeat number:").toIntOrNull() ?: 0

        for (qty in 1..readNumber) {
            io.writeln("$qty $readName")
        }

        io.writeln("End!")
    }

}