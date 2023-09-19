import time
import random
import threading

def worker(lock: threading.Event):
    i = 0
    while True:
        print(f"worker do job {i}")
        i += 1
        lock.clear()
        lock.wait()

def monitor(lock: threading.Event):
    while True:
        sleep_time = random.randint(1, 5)
        time.sleep(sleep_time)
        print('===')
        print('after monitor sleep', sleep_time)
        lock.set()

lock = threading.Event()

t0 = threading.Thread(target=monitor, args=[lock])
t1 = threading.Thread(target=worker, args=[lock])

t0.start()
t1.start()