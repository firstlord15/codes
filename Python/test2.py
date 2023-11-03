def open_addressing(A):
    size = 9
    hashtable = [None] * size
    print(hashtable)
 
    def hash_function(key):
        return (11 * key + 4) % size
 
    for key in A:
        index = hash_function(key)
        print(f'key: {key}, key_bf_mod: {11 * key + 4}, index:{index}')
        while hashtable[index] is not None:
            index = (index + 1) % size
        hashtable[index] = key
 
    return hashtable
 
 
def closed_addressing(A):
    size = 9
    hashtable = [[] for _ in range(size)]
    mod_set = set()
    #print(hashtable)
 
    def hash_function(key):
        return (11 * key + 4) % size
 
    for key in A:
        index = hash_function(key)
        mod_set.add(index)
        hashtable[index].append(key)
 
    print(mod_set)
 
    return hashtable
 
 
A = [67, 13, 49, 24, 40, 33, 58]
 
print("Открытая адресация:")
result_open_addressing = open_addressing(A)
print(result_open_addressing)
 
print("Закрытая адресация:")
result_closed_addressing = closed_addressing(A)
print(result_closed_addressing)