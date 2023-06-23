from typing import Any
from LinkedList import *


class Stack:
    def __init__(self):
        self.__data = LinkedList()

    def push(self, item: Any) -> None:
        self.__data.add(item)

    def pop(self) -> Any:
        return self.__data.shift()

    def top(self) -> Any:
        return self.__data.get(0)

    def is_empty(self) -> bool:
        return self.__data.is_empty()

    def size(self) -> int:
        return self.__data.size()

    def clear(self):
        self.__data = LinkedList()

    def show(self):
        print('\n'.join(str(item) for item in self.__data))


stack = Stack()
assert stack.is_empty() == True
assert stack.size() == 0

stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack.push(5)


# assert stack.is_empty() == False
# assert stack.size() == 5
#
# assert stack.top() == 5
# assert stack.pop() == 5
# assert stack.top() == 4
# assert stack.pop() == 4
#
# assert stack.is_empty() == False
# assert stack.size() == 3
#
# stack.show()


def is_palindrome(word):
    word = word.lower()
    rword = ""

    stack = Stack()

    for char in word:
        stack.push(char)

    while not stack.is_empty():
        rword += stack.pop()

    return word == rword


assert is_palindrome('наган') == True
assert is_palindrome('привет') == False


def brackets_checker(string: str) -> bool:
    open_allowed = '([{'
    close_allowed = ')]}'

    def matches(o, c):
        try:
            return open_allowed.index(o) == close_allowed.index(c)
        except:
            return False

    stack = Stack()

    for char in string:
        if char in open_allowed:
            stack.push(char)
        else:
            if stack.is_empty():
                return False
            if not matches(stack.pop(), char):
                return False

    if stack.is_empty():
        return True
    else:
        return False


def dec2any(dec: int, base: int) -> str:
    allowed = '0123456789ABCDEF'
    data = Stack()
    while dec > 0:
        data.push(dec % base)
        dec = dec // base
    s = ''
    while not data.is_empty():
        s += allowed[data.pop()]
    return s

# print(dec2any(196, 2))
# print(dec2any(255, 8))
# print(dec2any(196, 16))

# print(brackets_checker('{{([][])}()}'))
