# первое зажание

# class Node:
#     def __init__(self, data, next=None):
#         self.data = data
#         self.next = next


# class SiglyLinkedList:

#     def __init__(self):
#         self.head = None
#         self._size = 0

#     def iterate(self):
#         curr = self.head
#         while curr:
#             print(curr.data)
#             curr = curr.next

#     def insert(self, data):
#         self.head = Node(data, self.head)
#         self._size += 1

#     def append(self, data):
#         if not self.head:
#             self.head = Node(data)
#         else:
#             curr = self.head
#             while curr.next:
#                 curr = curr.next
#             curr.next = Node(data)
#         self._size += 1


#     def remove(self):
#         if not self.head:
#             return
#         self.head = self.head.next
#         self._size -= 1


#     def delete(self):
#         if not self.head:
#             return
#         if not self.head.next:
#             self.head = None
#         else:
#             curr = self.head
#             while curr.next.next:
#                 curr = curr.next
#             curr.next = None
#         self._size -= 1

#     def size(self):
#         return self._size

# linked_list = SiglyLinkedList()

# linked_list.append('первый')
# linked_list.append('второй')
# linked_list.insert('в голове')
# linked_list.append('в хвосте')
# linked_list.iterate()
# linked_list.size()
# linked_list.delete()
# linked_list.remove()
# linked_list.size()
# linked_list.iterate()
# linked_list.delete()
# linked_list.remove()
# linked_list.size()

# второе зажание

# class Stack:
#     def __init__(self):
#         self.items = []

#     def push(self, item):
#         self.items.append(item)

#     def pop(self):
#         if not self.is_empty():
#             return self.items.pop()

#     def peek(self):
#         if not self.is_empty():
#             return self.items[-1]

#     def is_empty(self):
#         return len(self.items) == 0

#     def size(self):
#         return len(self.items)

# m = Stack()
# m.push('x')
# m.push('y')
# m.pop()
# m.push('z')
# m.peek()

# m = Stack()
# m.push('x')
# m.push('y')
# m.push('z')

# while not m.is_empty():
#     m.pop()
#     m.pop()

# while not m.is_empty():
#     print(m.peek())
#     m.pop()

from collections import deque

class Queue():

    def __init__(self):
        self._queue = deque()
    
    def enqueue(self, item):
        self._queue.append(item)

    def dequeue(self):
        return self._queue.popleft()
    
    def is_empty(self):
        return len(self._queue) == 0

# q = Queue()
# q.enqueue('hello')
# q.enqueue('dog')
# q.enqueue(3)
# q.dequeue()

# while not q.is_empty():
#     print(q.dequeue())

n = int(input("Введите число: "))
names = input("Введите имена детей (через пробел)").split()
q = Queue()

for name in names:
    q.enqueue(name)

while not q.is_empty():
    
    for i in range(n-1):
        q.enqueue(q.dequeue())

    rm_name = q.dequeue()
    
    if q.is_empty():
        print(f"Последний оставшийся ребенок: {rm_name}")
    else:
        print(f"{rm_name} выбывает из круга.")