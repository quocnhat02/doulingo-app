import numpy as np


# # Tạo mảng một chiều
# arr = np.array([1, 2, 3, 4, 5])
# print("Array:", arr)

# # Tạo mảng hai chiều
# arr2d = np.array([[1, 2, 3], [4, 5, 6]])
# print("2D Array:\n", arr2d)

# # Mảng các số không
# zeros = np.zeros((3, 4))
# print("Zeros Array:\n", zeros)

# # Mảng các số một
# ones = np.ones((2, 3))
# print("Ones Array:\n", ones)

# # Mảng số nguyên từ 0 đến 9
# arange = np.arange(10)
# print("Arange Array:", arange)

# # Mảng số từ 0 đến 1 với bước nhảy 0.1
# linspace = np.linspace(0, 1, 5)
# print("Linspace Array:", linspace)

# arr1 = np.array([1, 2, 3])
# arr2 = np.array([4, 5, 6])

# print("Addition:", arr1 + arr2)
# print("Subtraction:", arr1 - arr2)
# print("Multiplication:", arr1 * arr2)
# print("Division:", arr1 / arr2)

# arr = np.array([10, 20, 30, 40, 50])

# # Chỉ mục
# print("Element at index 2:", arr[2])

# # Cắt mảng
# print("Slice from index 1 to 4:", arr[1:4])

# Các Hàm Thống Kê
# data = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])

# print("Mean:", np.mean(data))
# print("Median:", np.median(data))
# print("Standard Deviation:", np.std(data))

# Chuyển Đổi Dữ Liệu
# float_arr = np.array([1.1, 2.2, 3.3])
# int_arr = float_arr.astype(int)

# print("Original Float Array:", float_arr)
# print("Converted to Integer Array:", int_arr)

# # Ma Trận và Tính Toán Đại Số
# matrix1 = np.array([[1, 2], [3, 4]])
# matrix2 = np.array([[5, 6], [7, 8]])

# product = np.dot(matrix1, matrix2)
# print("Matrix Product:\n", product)

# Tính định thức và ma trận nghịch đảo:
# from numpy.linalg import inv, det

# matrix = np.array([[1, 2], [3, 4]])

# print("Determinant:", det(matrix))
# print("Inverse Matrix:\n", inv(matrix))

# Làm Việc với Dữ Liệu Đúng Đắn
data = np.array([1, np.nan, 3, 4, np.nan, 6])

# Thay thế giá trị NaN bằng giá trị trung bình
mean = np.nanmean(data)
filled_data = np.nan_to_num(data, nan=mean)

print("Original Data:", data)
print("Filled Data:", filled_data)
