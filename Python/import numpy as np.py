import numpy as np

height = np.array([73.84701702, 68.78190405, 74.11010539, 71.7309784 , 69.88179586,
                   67.25301569, 68.78508125, 68.34851551, 67.01894966, 63.45649398])
weight = np.array([241.89356318, 162.31047252, 212.74085556, 220.0424703 ,
                   206.34980062, 152.21215576, 183.9278886 , 167.97111049,
                   175.9294404 , 156.39967639])

imt = weight / (height ** 2)

max_imt = imt.max()
max_index = imt.argmax()

max_height = height[max_index]
max_weight = weight[max_index]

imt_50 = np.percentile(imt, 50)
low_weights = weight[imt < imt_50]

print("Наибольший ИМТ:", max_imt)
print("Индекс человека с наибольшим ИМТ:", max_index)
print("Рост человека с наибольшим ИМТ:", max_height)
print("Вес человека с наибольшим ИМТ:", max_weight)
print("Вес людей с ИМТ ниже 50-процентиля:", low_weights)