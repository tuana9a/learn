
def my_range(*args):
    numargs = len(args)
    start = 0
    stop = 0
    step = 1

    if numargs < 1:
        raise ValueError("f")
    elif numargs == 1:
        stop = args[0]
    elif numargs == 2:
        (start, stop) = args
    elif numargs == 3:
        (start, stop, step) = args
    else:
        raise ValueError("f")
    
    # generator
    i = start
    while i <= stop:
        yield i
        i += step

for i in my_range(1, 10 ,1): print(i, end=' ')
