# import re

# s = "ratmir.yuldashev28@mail.ru"

# result = re.match(r'ratmir', s)

# print(f'start = {result.start()}, end = {result.end()}')


def memoize(fn):
    memo = {}

    def wrapper(n):
        if n not in memo:
            memo[n] = fn(n)
        return memo[n]

    return wrapper


@memoize
def square(n):
    print('[System]: Вычисляется')
    return n ** 2


# square = memoize(square)

@memoize
def fib(n):
    print(f'[System]: Вычисляется {n}')
    if n in [0, 1]: return n
    return fib(n - 1) + fib(n - 2)


# fib = memoize(fib)

print(square(10))
print(square(10))
print(square(10))
print(square(10))
print(square(10))

print(square(20))
print(square(20))
print(square(20))
print(square(20))
print(square(20))

print(square(30))
print(square(30))
print(square(30))
print(square(30))
print(square(30))

print(fib(3))
print(fib(3))
print(fib(3))
print(fib(3))
print(fib(3))

print(fib(501))
print(fib(500))
print(fib(500))
print(fib(500))
