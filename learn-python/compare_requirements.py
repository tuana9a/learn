file = open('../test.txt','r')
temp = file.read().split('\n')
redunt = set()
for dep in temp:
    redunt.add(dep)

file = open('../requirements.txt','r')
temp = file.read().split('\n')
require = set()
for dep in temp:
    require.add(dep)

for dep in list(redunt.difference(require)):
    print(dep)