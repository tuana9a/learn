a = """Lorem ipsum dolor sit amet,
consectetur adipiscing elit,
sed do eiusmod tempor incididunt
ut labore et dolore magna aliqua."""
print(a)

# STRING FORMAT
x = 'hello {1} {0}'.format(10, 20) # change default order of format
print(x) 
x = 'hello "{:<10}" and "{:>5}"'.format(1, 100) # prinf
print(x)
x = 'hello "{:<010}" and "{:>05}"'.format(1, 100) # prinf
print(x)

# STRING METHOD
a = "Hello, World!"
print(a[1])
print(len(a))

# STRING PROCESS
for x in "banana":
    print(x)

# check child
txt = "The best things in life are free!"
print("free" in txt)
print("tuan" in txt)
if "free" in txt:
    print("Yes, 'free' is present.")

txt = "The best things in life are free!"
print("expensive" not in txt)

# access child string
b = "Hello, World!"
print(b[2:5])   #EXPLAIN: lấy từ 2 -> 4
print(b[:5])    #EXPLAIN: lấy từ đầu -> 4
print(b[2:])    #EXPLAIN: lấy từ 2 -> cuối
#EXPLAIN: âm là lấy ngược lại
print(b[:-2])   #EXPLAIN: lấy từ đầu đến trước kết 2 vị trí
print(b[-2:])   #EXPLAIN: lấy từ cuối 2 đến cuối

a = "  Hello, World!   "
print(a.upper())
print(a.lower())
a = " Hello, World! "
print(a.strip())
print(a.replace("l", "LOL"))
print(a.split(",")) # returns ['Hello', ' World!']