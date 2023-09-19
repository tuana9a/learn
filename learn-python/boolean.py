print(bool("Hello"))
print(bool(15))
print(bool(["apple", "cherry", "banana"]))
# đa số các giá trị là True nếu "chứa" giá trị ý nghĩa

print(bool(False))
print(bool(None))
print(bool(0))
print(bool(""))
print(bool(()))
print(bool([]))
print(bool({}))
# ngược lại giá trị "không có ý nghĩa" sẽ trả vè False

class myclass():
  def __len__(self):
    return 0

myobj = myclass()
print(bool(myobj))
# chú ý cuối là phương thức đặc biệt __len__() quyết định bool() của nó