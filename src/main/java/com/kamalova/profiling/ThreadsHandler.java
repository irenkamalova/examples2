package com.kamalova.profiling;

import java.util.Map;

public class ThreadsHandler {

    public static void getThreadsInfo() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] elements = entry.getValue();
            System.out.println("Thread is: " + thread.getName());
            for (StackTraceElement element : elements) {
                System.out.println("----------------------------------");
                System.out.println("Class is " + element.getClassName());
                System.out.println("File is " + element.getFileName());
                System.out.println("Method is " + element.getMethodName());
                System.out.println("Is Native method " + element.isNativeMethod());
                System.out.println("Line number " + element.getLineNumber());
                System.out.println("----------------------------------");
            }

        }
    }

    public static void main(String[] args) {
        ThreadsHandler.getThreadsInfo();
    }
}

/*
Thread is: Monitor Ctrl-Break
----------------------------------
Class is java.lang.Class
File is Class.java
Method is forName0
Is Native method true
Line number -2
----------------------------------
----------------------------------
Class is java.lang.Class
File is Class.java
Method is forName
Is Native method false
Line number 264
----------------------------------
----------------------------------
Class is java.net.ProxySelector
File is ProxySelector.java
Method is <clinit>
Is Native method false
Line number 72
----------------------------------
----------------------------------
Class is java.net.SocksSocketImpl$3
File is SocksSocketImpl.java
Method is run
Is Native method false
Line number 356
----------------------------------
----------------------------------
Class is java.net.SocksSocketImpl$3
File is SocksSocketImpl.java
Method is run
Is Native method false
Line number 354
----------------------------------
----------------------------------
Class is java.security.AccessController
File is AccessController.java
Method is doPrivileged
Is Native method true
Line number -2
----------------------------------
----------------------------------
Class is java.net.SocksSocketImpl
File is SocksSocketImpl.java
Method is connect
Is Native method false
Line number 353
----------------------------------
----------------------------------
Class is java.net.Socket
File is Socket.java
Method is connect
Is Native method false
Line number 589
----------------------------------
----------------------------------
Class is java.net.Socket
File is Socket.java
Method is connect
Is Native method false
Line number 538
----------------------------------
----------------------------------
Class is java.net.Socket
File is Socket.java
Method is <init>
Is Native method false
Line number 434
----------------------------------
----------------------------------
Class is java.net.Socket
File is Socket.java
Method is <init>
Is Native method false
Line number 211
----------------------------------
----------------------------------
Class is com.intellij.rt.execution.application.AppMainV2$1
File is AppMainV2.java
Method is run
Is Native method false
Line number 59
----------------------------------
Thread is: main
----------------------------------
Class is java.lang.Thread
File is Thread.java
Method is dumpThreads
Is Native method true
Line number -2
----------------------------------
----------------------------------
Class is java.lang.Thread
File is Thread.java
Method is getAllStackTraces
Is Native method false
Line number 1610
----------------------------------
----------------------------------
Class is com.kamalova.profiling.ThreadsHandler
File is ThreadsHandler.java
Method is getThreadsInfo
Is Native method false
Line number 8
----------------------------------
----------------------------------
Class is com.kamalova.profiling.ThreadsHandler
File is ThreadsHandler.java
Method is main
Is Native method false
Line number 27
----------------------------------
Thread is: Signal Dispatcher
Thread is: Finalizer
----------------------------------
Class is java.lang.Object
File is Object.java
Method is wait
Is Native method true
Line number -2
----------------------------------
----------------------------------
Class is java.lang.ref.ReferenceQueue
File is ReferenceQueue.java
Method is remove
Is Native method false
Line number 143
----------------------------------
----------------------------------
Class is java.lang.ref.ReferenceQueue
File is ReferenceQueue.java
Method is remove
Is Native method false
Line number 164
----------------------------------
----------------------------------
Class is java.lang.ref.Finalizer$FinalizerThread
File is Finalizer.java
Method is run
Is Native method false
Line number 212
----------------------------------
Thread is: Reference Handler
----------------------------------
Class is java.lang.Object
File is Object.java
Method is wait
Is Native method true
Line number -2
----------------------------------
----------------------------------
Class is java.lang.Object
File is Object.java
Method is wait
Is Native method false
Line number 502
----------------------------------
----------------------------------
Class is java.lang.ref.Reference
File is Reference.java
Method is tryHandlePending
Is Native method false
Line number 191
----------------------------------
----------------------------------
Class is java.lang.ref.Reference$ReferenceHandler
File is Reference.java
Method is run
Is Native method false
Line number 153
----------------------------------
 */
