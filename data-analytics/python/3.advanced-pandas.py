import pandas as pd
import os

# Lấy đường dẫn tuyệt đối đến thư mục chứa file Python hiện tại
current_dir = os.path.dirname(os.path.abspath(__file__))

# Tạo đường dẫn đầy đủ đến file CSV
csv_path = os.path.join(current_dir, 'data.csv')

# Đọc dữ liệu từ file CSV:
# df = pd.read_csv(csv_path)
# print(df)

# In ra đường dẫn để kiểm tra
# print(f"Đang đọc file từ: {csv_path}")

# print(df['Name'])
# print(df.iloc[0])
# print(df[df['Age'] > 30])

# df.info()
# df.describe()

# Thêm cột:
# df['Salary'] = [50000, 60000, 70000, 80000]

# Xóa cột:
# df.drop(columns=['Salary'], inplace=True)

# Xóa hàng:
# df.drop(index=0, inplace=True)  # Xóa hàng đầu tiên

# 5. Xử lý dữ liệu bị thiếu(Missing Data)
# Trong phân tích dữ liệu, việc xử lý dữ liệu bị thiếu là rất quan trọng.
# df.isnull().sum()

# # Điền bằng giá trị trung bình
# df['Age'].fillna(df['Age'].mean(), inplace=True)

# df.dropna(axis=0, inplace=True)  # Xóa các hàng chứa giá trị thiếu

# 6. Nhóm dữ liệu (GroupBy)
# Pandas cung cấp phương thức groupby để nhóm dữ liệu theo một cột và thực hiện các phép tính như tổng, trung bình.
# df.groupby('Category')['Revenue'].sum()

# df.groupby('Category')['Revenue'].mean()

# 7. Thao tác với chuỗi ký tự(String Handling)
# Làm việc với dữ liệu dạng chuỗi:
# df['Name'] = df['Name'].str.upper()  # Chuyển tất cả sang chữ hoa
# df[df['City'].str.contains('New')]

# 8. Ghép và nối DataFrames(Merging & Joining)
# Bạn có thể ghép hai DataFrames với nhau giống như việc thực hiện các thao tác JOIN trong SQL.
# df1.merge(df2, on='ID', how='inner')  # Inner join

# pd.concat([df1, df2], axis=0)  # Nối theo hàng


# 9. Áp dụng hàm trên DataFrame(Apply Functions)
# Pandas cho phép áp dụng hàm trên từng phần tử của DataFrame.
# Tăng tuổi lên 1 cho tất cả các hàng
# df['Age'] = df['Age'].apply(lambda x: x + 1)

# df.map(lambda x: x*2 if type(x) == int else x)

# 10. Pivot Table và Crosstab
# Pivot Table giúp tổng hợp dữ liệu theo nhiều chiều khác nhau.

data = {
    'Date': ['2024-01-01', '2022-11-02', '2024-01-02', '2024-01-03', '2024-01-03', '2024-03-04'],
    'Product': ['Product A', 'Product B', 'Product A', 'Product C', 'Product B', 'Product A'],
    'Category': ['Category 1', 'Category 2', 'Category 1', 'Category 3', 'Category 2', 'Category 1'],
    'Quantity': [10, 5, 2, 3, 4, 1],
    'Unit Price': [100, 150, 100, 200, 150, 100],
    'Revenue': [1000, 750, 200, 600, 600, 100]
}

# df = pd.DataFrame(data)

# print(df)

# print(df.pivot_table(index='Category', values='Revenue', aggfunc='sum'))
# print(pd.crosstab(df['Product'], df['Category']))

# 11. Xử lý dữ liệu thời gian(Time Series Data)
# Pandas có các công cụ mạnh mẽ để làm việc với dữ liệu thời gian:
# df['Date'] = pd.to_datetime(df['Date'])
# print(df[df['Date'] > '2023-01-01'])
# Tổng hợp dữ liệu theo tháng


# print(df.set_index('Date').resample('ME').sum())

# 12. Xử lý dữ liệu lớn(Large Data Processing)
# Khi làm việc với dữ liệu lớn, Pandas cung cấp một số công cụ để xử lý:
# for chunk in pd.read_csv(csv_path, chunksize=1000):
#     print(chunk)

# Chuyển đổi kiểu dữ liệu để tiết kiệm bộ nhớ
# df['Age'] = df['Age'].astype('int32')


# 13. Phân tích dữ liệu bán hàng
# Bạn có thể kết hợp tất cả các kiến thức trên để thực hiện một bài phân tích dữ liệu thực tế.

# Ví dụ: Phân tích doanh thu theo thời gian và tìm sản phẩm bán chạy nhất.

# Đọc dữ liệu từ tệp CSV:
df = pd.DataFrame(data)

df['Date'] = pd.to_datetime(df['Date'])

# Làm sạch dữ liệu (xử lý giá trị thiếu):
df['Revenue'].fillna(df['Revenue'].mean())

# Tạo cột mới 'Month' để lấy giá trị tháng từ 'Date'
df['Month'] = df['Date'].dt.to_period('M')  # 'M' là tháng


# Nhóm và tính tổng doanh thu theo sản phẩm:
total_revenue = df.groupby('Product')['Revenue'].sum()
print("Total: ", total_revenue)

# print(df.pivot_table(index='Date', values='Revenue', aggfunc='sum'))

# Tạo pivot table để phân tích doanh thu theo tháng:
monthly_revenue = df.groupby('Month')['Revenue'].sum()

print(monthly_revenue)
