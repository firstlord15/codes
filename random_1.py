from random import randint

n = 13
result = ''

for _ in range(n):
    result += str(randint(0, 9))

print(result)