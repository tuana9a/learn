x = 42
print("hello {}".format(x))
# print("hello {}".format()) # error
print("hello {} and {}".format(x, x))
print("hello %d" % (x))
print("hello %d and %d" % (x, x))
print("test", end=" ") # change default end is '\n'
print(f"hello {x}")
print(f"bin of x is {x:32b} hex of x is {x:32x}")
