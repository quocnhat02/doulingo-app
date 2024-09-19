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
df.drop(index=0, inplace=True)  # Xóa hàng đầu tiên

print(df)
