import random as rn
from colorama import init, Fore
init()

array = []

for i in range(100):
    array.append(rn.randint(0, 100))


#########################################################################

def SortPusr(array):
    col2 = 0
    for i in range(len(array) - 1):
        for j in range(len(array) - i - 1):
            if (array[j] > array[j+1]):
                array[j], array[j+1] = array[j+1], array[j]
                col2 += 1
    
    print("Сортировка Пузырьком:", array, '\nперестоновок:', col2)
    return array

#########################################################################

def Sort_Shaker(array):
    col = 0
    start = 0
    end = len(array) - 1
    move = True

    while (move == True): 
        
        move = False
          
        # проход слева направо
        for i in range(start, end): 
            if (array[i] > array[i + 1]) : 
                # обмен элементов
                array[i], array[i + 1] = array[i + 1], array[i] 
                move = True
                col += 1
  
        # если не было обменов прерываем цикл
        if (not(move)): 
            break

        move = False

        end = end - 1
  
        #проход справа налево
        for i in range(end - 1, start - 1, -1): 
            if (array[i] > array[i + 1]): 
                # обмен элементов
                array[i], array[i + 1] = array[i + 1], array[i] 
                move = True
                col += 1
 
        start = start + 1
    
    
    print("Сортировка Шейкером:", array, '\nперестоновок:', col)
    return array


#########################################################################

def SortVs(array):
    for i in range(1, len(array)):
        temp = array[i]
        j = i-1
        while(j>=0 and temp < array[j]):
            array[j+1] = array[j]
            j -= 1
        array[j+1] = temp
        
    return array

#########################################################################
print(Fore.MAGENTA)
print(array, '\n')

print(Fore.CYAN)
SortPusr(array)

print(Fore.GREEN)
Sort_Shaker(array)

print(Fore.YELLOW)
print("Сортировка Вставкой:", SortVs(array))
print(Fore.WHITE)
