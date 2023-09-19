import time
def print_take_time(func):
    def wrapper():
        t1 = time.time()
        func()
        t2 = time.time()
        print(f"took: {t2 - t1}s")
    return wrapper

def print_take_time_v1(func):
    def wrapper():
        t1 = time.time()
        result = func()
        t2 = time.time()
        print(f"took: {t2 - t1}s")
        return result
    return wrapper

@print_take_time_v1
def some_func():
    total = 0
    for i in range (1, 1000000):
        total += i
    return total

print(some_func())