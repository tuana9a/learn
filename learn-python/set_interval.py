import threading

def setInterval(func, sec, delay=True):
    def func_wrapper():
        setInterval(func, sec)
        func()

    if(not delay):
        func()

    t = threading.Timer(sec, func_wrapper)
    t.start()
    return t
