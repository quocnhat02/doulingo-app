# Bối cảnh dự án:
# Bạn đang làm việc với dữ liệu bán hàng hàng tháng của một công ty. Bộ dữ liệu chứa các cột sau:

# Month: Tháng của năm.
# Sales: Doanh thu bán hàng trong tháng đó.
# Mục tiêu:
# Tính toán các số liệu thống kê cơ bản cho doanh thu.
# Xử lý dữ liệu bị thiếu (missing values).
# Dự đoán doanh thu trong tương lai bằng cách sử dụng các kỹ thuật hồi quy đơn giản.
# Trực quan hóa kết quả.

# Bước 1: Tạo Dữ Liệu Bán Hàng Mẫu
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

# Tạo dữ liệu bán hàng mẫu
data = {
    'Month': np.arange(1, 13),
    'Sales': np.array([200, 220, np.nan, 260, 280, 290, np.nan, 310, 320, 330, 340, np.nan])
}

df = pd.DataFrame(data)
print("Original Sales Data:\n", df)

# Bước 2: Tính Toán Thống Kê Cơ Bản
# Sử dụng NumPy để tính các chỉ số thống kê cơ bản như trung bình(mean), độ lệch chuẩn(standard deviation), và tổng doanh thu(total sales).
# Tính các giá trị thống kê cơ bản
mean_sales = np.nanmean(df['Sales'])
std_sales = np.nanstd(df['Sales'])
total_sales = np.nansum(df['Sales'])

print(f"Mean Sales: {mean_sales}")
print(f"Standard Deviation: {std_sales}")
print(f"Total Sales: {total_sales}")

# Bước 3: Xử Lý Dữ Liệu Bị Thiếu
# Trong dữ liệu này, một số giá trị doanh thu bị thiếu(NaN). Bạn có thể sử dụng các phương pháp khác nhau để xử lý dữ liệu bị thiếu, chẳng hạn như điền giá trị trung bình.
# Điền giá trị NaN bằng giá trị trung bình của cột Sales
df['Sales_filled'] = np.where(np.isnan(df['Sales']), mean_sales, df['Sales'])
print("Sales Data After Filling NaN:\n", df)

# Bước 4: Dự Đoán Doanh Thu Trong Tương Lai(Linear Regression)
# Dự đoán doanh thu trong tương lai bằng cách sử dụng mô hình hồi quy tuyến tính đơn giản(linear regression) trên dữ liệu doanh thu hiện có. NumPy có thể giúp bạn tính toán hệ số của hồi quy tuyến tính.
# Chuẩn bị dữ liệu
X = df['Month'].values.reshape(-1, 1)  # Tháng (biến độc lập)
y = df['Sales_filled'].values  # Doanh thu (biến phụ thuộc)

# Tính toán hệ số hồi quy tuyến tính (y = mx + b)
A = np.vstack([X.T, np.ones(len(X))]).T
m, b = np.linalg.lstsq(A, y, rcond=None)[0]

print(f"Linear Regression Coefficient (m): {m}")
print(f"Linear Regression Intercept (b): {b}")

# Dự đoán doanh thu cho tháng 13 và 14
future_months = np.array([13, 14])
predicted_sales = m * future_months + b
print(f"Predicted Sales for Month 13 and 14: {predicted_sales}")

# Bước 5: Trực Quan Hóa Kết Quả
# Sử dụng matplotlib để vẽ biểu đồ doanh thu thực tế và doanh thu dự đoán

# Vẽ dữ liệu doanh thu thực tế và dự đoán
plt.plot(df['Month'], df['Sales_filled'], label='Actual Sales', marker='o')
plt.plot(future_months, predicted_sales,
         label='Predicted Sales', marker='x', linestyle='--')

# Thêm nhãn và tiêu đề
plt.xlabel('Month')
plt.ylabel('Sales')
plt.title('Sales Data and Future Predictions')
plt.legend()
plt.show()
