# class Node:
# 	def __init__(self, data, next = None):
# 		self.data = data
# 		self.next = next

# 	def index_find(index, elem, i = 1):
		
# 		while (elem):
# 			elem = elem.next
# 			i += 1
# 			if i == index:
# 				return elem.data
# 		return None
# tail = Node('Хвост')
# second = Node('Второй узел', tail)
# first = Node('Первый узел', second)
# head = Node('Голова списка', first)

# print(Node.index_find(int(input('> ')), head))

import re

pattern = r'\bАн(н(ы|ой|е|у|ой|а)?|е)?\b'
text = "Меня зовут Анна, но мои друзья называют меня Аня"

if re.findall(pattern, text):
	print(True)
else:
	print(False)

