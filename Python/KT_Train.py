from typing import Any
from colorama import Fore, init

init()


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
        print('\n'.join(str(item) for item in self.__data))

    def get(self):
        return '\n'.join(str(item) for item in self.__data)


def Sorting_of_Wagons(data: str):
    gridlock = Stack()
    wagons = data.split()
    trigger_wagon = 1  # тригер для переноса вагонов в путь 2

    # весь процесс
    for wagon in wagons:
        wagon = int(wagon)
        gridlock.push(wagon)
        print(Fore.GREEN + f'Ввел: {wagon}')

        # проверочка для того чтобы понять, что выводить
        if wagon == trigger_wagon:
            while not gridlock.is_empty() and gridlock.top() == trigger_wagon:
                print(Fore.YELLOW + f'Вывел {gridlock.pop()}')
                trigger_wagon += 1

    # конечный результат
    if gridlock.is_empty():
        return "Все вывелось"
    else:
        return "Не получилось"


answer = input('')
print(Sorting_of_Wagons(answer))

# stack = Stack()
# stack.push(1)
# stack.push(2)
# stack.push(3)
# stack.push(4)
# print(stack.get())
