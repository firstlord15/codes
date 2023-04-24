import re

def read_and_write_file(input_file, output_file):    
    # открываем файл для чтения
    file = open(input_file, 'r', encoding='UTF-8')
    # открываем новый файл для записи
    new_file = open(output_file, 'w', encoding='UTF-8')
    
    # читаем файл построчно
    for line in file:
        # используем регулярное выражение для поиска времени, номера поезда и города
        match = re.search(r'Рейс (\d+) (\w+) (из|в) (\w+) в (\d+:\d+:\d+)', line)
        if match:
            # формируем новую строку с нужным форматированием
            new_line = f"[{match.group(1)}] - Поезд № {match.group(2)} {match.group(3)} {match.group(4)}\n"
            # записываем новую строку в новый файл
            new_file.write(new_line)
    
    # закрываем файлы
    file.close()
    new_file.close()
    
    new_file = open(output_file, 'r', encoding='UTF-8')
    return "Готово"

input_file = input('Введите название файла: ').strip()
print(read_and_write_file(input_file, 'writtenfile.txt'))