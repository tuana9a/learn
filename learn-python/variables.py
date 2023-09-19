#===================================
x = str(3)
y = int(3.6)
z = float(y)
print(x)
print(y)
print(z)

# check type của biến
print(type(x))
print(type(y))
print(type(z))

#===================================
# gán multiple biến dị vãi, chắc liên quan tới hàm trả về nhiều giá trị
x, y, z = "Orange", "Banana", "Cherry"
print(x)
print(y)
print(z)

#===================================
x = y = z = "Orange"
print(x)
print(y)
print(z)

#===================================
fruits = ["apple", "banana", "cherry"]
x, y, z = fruits
print(x)
print(y)
print(z)

#===================================
def myfunc():
    global x
    x = "fantastic"
# biến x bthg là local scope nhưng nếu thêm global trước thì nó là biến global
myfunc()
print("x is " + x)

#===================================
x = "awesome"
# do đó nếu muốn thay đổi biến x global thì cần phải thêm từ khóa global
# nếu không nó sẽ hiểu là local scope
def myfunc():
#   global x
  x = "fantastic"

myfunc()

print("Python is " + x)