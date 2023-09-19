import platform
print("this is python version: {}".format(platform.python_version()))

x = 10
try:
    print(x)
except:
    print("An exception occurred")

del x
try:
    print(x)
except NameError as e:
    print(e)
except:
    print("Something else went wrong")


print(__name__)


def test1():
    x = 1000000


test1()

# print(x) # Error x is not defined
if True:
    x = 11
print(x)

x = (1, 2, 3, 4)
print(type(x))
x = [1, 2, 3, 4]
print(type(x))
x = {1, 3, 4}
print(type(x))
x = range(1, 10)
print(type(x))
x = range(1, 10, 3)
for l in x:
    print(l)
print(type(type("tuan")))
print(isinstance("tuan", str))
# print("tuan" is 'tuan')
# print("tuan" == 'tuan')
