def my_function():
  print("Hello from a function")

my_function()


def my_function(child3, child2, child1):
  print("The youngest child is " + child3)

my_function(child1 = "Emil", child2 = "Tobias", child3 = "Linus")
# my_function(child1 = "Emil", child2 = "Tobias") #Error

def my_function(country = "Norway"):
  print("I am from " + country)

my_function("Sweden")
my_function()

# LAMBDA 
def myfunc(n):
  return lambda a : a * n

mydoubler = myfunc(2)
mytripler = myfunc(3)

print(mydoubler(11))
print(mytripler(11))

def f():
    return 1
def f1():
    print("f1")
def f2():
    return

print(f())
print(f1())
print(f2())

#=============
def my_function(*kids):
  print("The youngest child is " + kids[2])
  for kid in kids:
    print(kid)

my_function("Emil", "Tobias", "Linus")

"""
This way the function will receive a dictionary of arguments, and can access the items accordingly:
"""
def my_function(**kid):
  print(f'type of dict {type(kid)}')
  print("His last name is " + kid["lname"])

my_function(fname = "Tobias", lname = "Refsnes")