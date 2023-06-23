from typing import Any
import sys


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.__head = None
        self.__size = 0
        self.__tail = None

    def is_empty(self):
        return self.__head is None

    def size(self):
        return self.__size

    def search(self, item):
        current = self.__head
        while not current is None:
            if current.data == item:
                return True
            current = current.next

        return False

    def remove(self, item):
        self.__size -= 1
        if self.__head is None: return None

        if self.__head.data == item:
            self.__head = self.__head.next
            self.__size -= 1
            return f'System: [Ready! item {item} was remove]'

        current = self.__head
        while current.next is not None:
            if current.next.data == item:
                current.next = current.next.next
                self.__size -= 1
                return f'System: [Ready! item {item} was remove]'
            current = current.next

    def add(self, item):
        node = Node(item)
        if self.is_empty():
            self.__head = node
            self.__tail = node
        else:
            node.next = self.__head
            self.__head = node
        self.__size += 1

    def append(self, item):
        node = Node(item)
        if self.is_empty():
            self.__head = node
            self.__tail = node
        else:
            self.__tail.next = node
            self.__tail = node
        self.__size += 1

    def shift(self):
        if self.__head is None: return None
        node = self.__head
        self.__head = node.next
        node.next = None
        self.__size -= 1
        return node.data

    def pop(self):
        if self.__tail is None: return None
        node = self.__tail
        if self.__head == self.__tail:
            self.__head = None
            self.__tail = None
        else:
            current = self.__head
            while current.next != self.__tail:
                current = current.next
            current.next = None
            self.__tail = current
        self.__size -= 1
        return node.data

    def __repr__(self):
        if self.__head is None:
            return '[]'
        current = self.__head
        out = ''
        while not current is None:
            out += str(current.data) + ', '
            current = current.next
        return f'[{out.rstrip(", ")}]'

    def get(self, index=None):
        if self.__head is None: return None
        if index >= self.size(): return None
        current = self.__head
        if index == 0: return current.data
        cnt = 1
        while cnt < self.size():
            current = current.next
            if index == cnt:
                return current.data
            cnt += 1
        return None

    def __getitem__(self, index):
        if index >= self.size(): raise IndexError
        return self.get(index)


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
        print(' '.join(str(item) for item in self.__data))


class Interpreter:
    def __init__(self, data: str):
        self.data = data

    # проверка скобок
    def brackets_checker(self) -> bool:
        stack = Stack()

        for char in self.data:
            if char == "(":
                stack.push(char)
            elif char == ")":
                if stack.is_empty():
                    return False
                stack.pop()
        return stack.is_empty()

    # Исправляем вносимые данные, то есть добовляем ' ' между цифрами, скобками и операциями
    def fix_data(self):
        string = ''
        if self.brackets_checker():
            for elements in self.data.split():
                for i in range(len(elements)):
                    token = elements[i]
                    if token.isdigit():
                        string += token
                    else:
                        string += ' ' + token + ' '
        else:
            print('[System]: Error')
            sys.exit()

        return string.split()

    # Конвертируем все выражение в RPN, с которым проще работать
    def create_to_rpn(self):
        # precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
        precedence = {'+': 1, '-': 1, '*': 1, '/': 1, '^': 1, '(': 3, ')': 3}
        oprations = '-+*/^'
        stack = Stack()
        arr = []
        # используем в качестве данных, уже изменный раннее list
        data = self.fix_data()

        for token in data:
            if token.isdigit():
                arr.append(token)
            elif token in oprations:
                while not stack.is_empty() and stack.top() in oprations and precedence[token] <= precedence[stack.top()]:
                    arr.append(stack.pop())
                stack.push(token)
            elif token == '(':
                stack.push(token)
            elif token == ')':
                while not stack.is_empty() and stack.top() != '(':
                    arr.append(stack.pop())
                if not stack.is_empty() and stack.top() == '(':
                    stack.pop()

        while not stack.is_empty():
            arr.append(stack.pop())

        return ' '.join(arr)

    # Тут все и решается
    
    def evaluating(self):
        rpn_exp = self.create_to_rpn().split()
        math_operation = {
            '+': lambda x, y: x + y,
            '-': lambda x, y: x - y,
            '*': lambda x, y: x * y,
            '/': lambda x, y: x / y,
            '^': lambda x, y: y ** x
        }
        stack = Stack()
        for element in rpn_exp:
            # добовляется число в stack
            # а если это операция, то последние 2 числа вырезаются и заменяются результатом
            if element.isdigit():
                stack.push(int(element))
            elif element in math_operation:
                first = stack.pop()
                second = stack.pop()

                # Тут мы и добовляем результат в stack, если не будет ошибки деления на 0
                if element == '/' and first == 0:
                    print('[System]: Error "На ноль делить нельзя"')
                    sys.exit()

                stack.push(math_operation[element](second, first))
            else:
                print(f'[System]: Error "Неизвестная операция: {element}"')
                sys.exit()

        return int(stack.top())

    def evaluate(self):
        return f'В результате, {self.data} == {self.evaluating()}'


interpreter = Interpreter('10 + ((122 + 3) * (14 * 6))')
print(interpreter.evaluate())
