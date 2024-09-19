import pandas as pd
import os

# Lấy đường dẫn tuyệt đối đến thư mục chứa file Python hiện tại
current_dir = os.path.dirname(os.path.abspath(__file__))

# Tạo đường dẫn đầy đủ đến file CSV
csv_path = os.path.join(current_dir, 'data.csv')

# Đọc dữ liệu từ file CSV:
df = pd.read_csv(csv_path)
print(df)

# In ra đường dẫn để kiểm tra
# print(f"Đang đọc file từ: {csv_path}")

# print(df['Name'])
# print(df.iloc[0])
# print(df[df['Age'] > 30])

# df.info()
# df.describe()

# Thêm cột:
df['Salary'] = [50000, 60000, 70000, 80000]

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


print(df)
