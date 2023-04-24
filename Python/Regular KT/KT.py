import re

def open_file(filename):
	file = open(filename, 'r', encoding='UTF-8')
	all_lines = file.readlines()
	result = []

	for line in all_lines:
		
		if 'Рейс' in line:
			result.append(line)

	file.close()
	return result

def match_data(filename):
	arr = open_file(filename)
	result = ''

	for line in arr:
		match = re.search(r'Рейс (\d+) (\w+) (из|в) (\w+) в (\d+:\d+:\d+)', line)

		rais_num = match.group(1)
		action = match.group(3)
		city = match.group(4)
		time = match.group(5)

		result += (f'[{time}] - Поезд № {rais_num} {action} {city}\n')

	return result

def write_file(filename_open, filename_write):
	file = open(filename_write, 'w', encoding='UTF-8')
	text = match_data(filename_open)
	
	file.write(text)
	file.close()
	
filename_open = input('Введите названия файла с которого будет считываться данные: ').strip()
write_file(filename_open, 'output.txt')
print('System: [Файл готов, проверайте :) ]')