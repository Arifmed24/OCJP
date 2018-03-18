* The class should extend RecursiveAction or RecursiveTask
* If the class extends recursiveAction, then it should override a protected _compute()_ method that takes no arguments and returns _void_.
* If the class extends RecursiveTask, then it should override a protected _compute()_ method that takes no arguments and returns a _generic type_ listed in the class definition.
* The _invokeAll()_ method takes two instances of fork/join class and does not return a result.
* The _fork()_ method causes a new task to be submitted to the pool and is similar to the thread executor _submit()_ method.
* The _join()_ method is called after the _fork()_ method and causes the current thread to wait for the results of the subtask.
* Unlike _fork()_, calling _compute()_ within itself causes the task to wait for the results of the subtask.
* The _fork()_ method should be called before the current thread performs a _compute()_ operation, with _join()_ called to read the results afterward.
* Since _compute()_ takes no arguments, the constructor of the class is often used to pass instructions to the task.
