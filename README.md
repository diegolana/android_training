# Android Training App

This App was created to work as a Kotlin palyground with the advantage that it has a command that works like an input prompt. This command will pause the code until the user enter something.

The **main goal** is to **help** to teach **beginners developers** how to develop **simple codes** and at the same time get used to the **Android development environment**. 

I created basic commands to **writing** and **reading** value. The commands have the same purpose of the well-known "print" and **"println"**, as well as the **"readLine"**. The names are purposely different to help students not to misplace them.

Use the Training class to create your own study code. The **main()** method will be the first method to run.


# Basic Commands

`write()` - Display on the **TextView** a text passed as parameter to this method in the form of a String.

`writeln()` - Display on the **TextView** a text passed as parameter to this method in the form of a String and break line at the end.

`read()` - Pause the code and wait the user enter some text on the **EditText** until the user press enter. The entered text is returned by this method as a String and the code continues to run from that point. The text passed as parameter will be displayed on the **TextView** before the code pause.

`clear()` - Remove all text from the **TextView** and continue to execute the code.


# Snippet Code

```
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
```

# Sample Images

![](https://github.com/diegolana/android_training/blob/main/TrainingSampleImg1.png)
![](https://github.com/diegolana/android_training/blob/main/TrainingSampleImg2.png)
