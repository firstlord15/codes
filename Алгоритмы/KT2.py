import random
import time


# Сортировка слияния
def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left, right)


def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result += left[i:]
    result += right[j:]

    return result


# Сортировка пузырьком
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


# Измерение времени
def measure_time(func):
    start_time = time.perf_counter()
    func()
    end_time = time.perf_counter()
    execution_time = end_time - start_time
    return execution_time


small_arr = [random.randint(-100, 100) for _ in range(10)]
middle_arr = [random.randint(-100, 100) for _ in range(1000)]
big_arr = [random.randint(-100, 100) for _ in range(10000)]
best_arr = list(range(1000))
worst_arr = list(range(1000))[::-1]

bs_best_arr_time = measure_time(lambda: bubble_sort(best_arr))
ms_best_arr_time = measure_time(lambda: merge_sort(best_arr))

print(f"Сортировка пузырьком на лучшем массиве: {bs_best_arr_time} секунд")
print(f"Сортировка слиянием на лучшем массиве: {ms_best_arr_time} секунд")

bs_mid_arr_time = measure_time(lambda: bubble_sort(middle_arr))
ms_mid_arr_time = measure_time(lambda: merge_sort(middle_arr))

print(f"Сортировка пузырьком на среднем массиве: {bs_mid_arr_time} секунд")
print(f"Сортировка слиянием на среднем массиве: {ms_mid_arr_time} секунд")

bs_worst_arr_time = measure_time(lambda: bubble_sort(worst_arr))
ms_worst_arr_time = measure_time(lambda: merge_sort(worst_arr))

print(f"Сортировка пузырьком на худшем массиве: {bs_worst_arr_time} секунд")
print(f"Сортировка слиянием на худшем массиве: {ms_worst_arr_time} секунд")

bs_small_arr_time = measure_time(lambda: bubble_sort(small_arr))
ms_small_arr_time = measure_time(lambda: merge_sort(small_arr))

print(f"Сортировка пузырьком на маленьком массиве: {bs_small_arr_time} секунд")
print(f"Сортировка слиянием на маленьком массиве: {ms_small_arr_time} секунд")

bs_big_arr_time = measure_time(lambda: bubble_sort(big_arr))
ms_big_arr_time = measure_time(lambda: merge_sort(big_arr))

print(f"Сортировка пузырьком на большом массиве: {bs_big_arr_time} секунд")
print(f"Сортировка слиянием на большом массиве: {ms_big_arr_time} секунд")
