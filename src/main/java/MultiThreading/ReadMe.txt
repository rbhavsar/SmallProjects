Start with https://www.youtube.com/watch?v=L95658yXRgI

Typing a doc at that time doc also check spelling mistake -
Take a process and break that process is the thread.

Octa Code CPU - We have 8 core.
Normal program run on Single thread , If you get expcption - Exception in thread main
Every java application has one thread - main

{1,2,3,.....,500} Multiply with 2 {2,4,6,....,1000} - this takes 8 secs as an example

We have quad core processor - if we spon of 4 thread then t1,t2,t3,t4. 4 thread process parallally then you can complete this task in 2 secs

class A{


}

class MyThread extends A,Thread{ // This is wrong , we can not do multiple inheritance in Java

}

You should use below

class MyThread extends A implements Runnable{


}