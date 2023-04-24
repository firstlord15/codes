def process(filename):
    f = open(filename, 'r', encoding="UTF-8")
    lines = len(f.readlines()) - 1
    line = open(filename).readlines()
    line = line[1:]
    result = 0

    if line[0].strip() == '':
        raise ValueError("Нету значения кол-во строк")
    else:
        rule = int(open(filename).readline(1).strip())

    if lines != rule:
        raise ValueError("Не верное количество строк")

    for i in range(len(line)):
        result += int(line[i].strip())

    return result

while True:
    try:
        filename = input("Введите имя файла: ")
        result = process(filename)
        print(result)
    
    except FileNotFoundError:
        print("Такого файла нету")
    except ValueError as e:
        print(e)
    except (TypeError, ValueError):
        print("хуйня с типом данных")
    except KeyboardInterrupt:
        print("\nПока!")
        break
    except Exception as e:
        print('Ошибка: ', e)
