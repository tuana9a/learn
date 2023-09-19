# Text Type    :	str
# Numeric Types:	int, float, complex
# Sequence Types:	list, tuple, range
# Mapping Type  :	dict
# Set Types     :	set, frozenset
# Boolean Type  :	bool
# Binary Types  :	bytes, bytearray, memoryview

# CAUTION: You cannot convert complex numbers into another number type.

#=============================================================================================
x = frozenset({"apple", "banana", "cherry"})	#frozenset	
print(x)
x = bytearray(5)	                #bytearray	
print(x)
x = memoryview(bytes(5))	        #memoryview	

#=============================================================================================
x = str("Hello World")  #str	
x = int(20)	            #int	
x = float(20.5)	        #float	
x = complex(1j)	        #complex	
x = range(6)	        #range	
x = bool(5)	            #bool	
x = bytes(5)	        #bytes	
x = bytearray(5)	    #bytearray	

#=============================================================================================
x = list(("apple", "banana", "cherry"))	    #list	
x = tuple(("apple", "banana", "cherry"))	#tuple	
x = dict(name="John", age=36)	            #dict	
x = set(("apple", "banana", "cherry"))	    #set	
x = frozenset(("apple", "banana", "cherry"))#frozenset	
x = memoryview(bytes(5))	                #memoryview

#=============================================================================================
x = 1 + 1J + 3 -5j
print(x, type(x))
x = 35e3
y = 12E4
z = -87.7e100

x = 1    # int
y = 2.8  # float
z = 1j   # complex

b = int(y)      #convert from float to int:
a = float(x)    #convert from int to float:
c = complex(x)  #convert from int to complex:

print(a)
print(b)
print(c)

print(type(a))
print(type(b))
print(type(c))

#=============================================================================================
x = 7
print(type(x))

class Duck:
    quack='quackkkkkkkkkkkkkk'

d = Duck()

print(type(d))
print(type(None))