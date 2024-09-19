# Bối cảnh dự án:
# Bạn có một bộ dữ liệu bán hàng từ một cửa hàng, chứa các thông tin về ngày bán hàng, danh mục sản phẩm, số lượng bán, giá bán, và doanh thu.

# Mục tiêu:
# Tính toán các chỉ số doanh thu trung bình, tổng doanh thu theo danh mục sản phẩm.
# Xử lý dữ liệu bị thiếu.
# Tìm sản phẩm bán chạy nhất.
# Phân tích xu hướng doanh thu theo thời gian.

# Bước 1: Tạo dữ liệu bán hàng mẫu
# Sử dụng Pandas để tạo một DataFrame từ một dictionary với các cột như Date, Product, Category, Quantity, Unit Price, và Revenue.

import pandas as pd

# Tạo dữ liệu bán hàng mẫu
data = {
    'Date': ['2024-01-01', '2024-01-02', '2024-01-02', '2024-01-03', '2024-01-03', '2024-01-04'],
    'Product': ['Product A', 'Product B', 'Product A', 'Product C', 'Product B', 'Product A'],
    'Category': ['Category 1', 'Category 2', 'Category 1', 'Category 3', 'Category 2', 'Category 1'],
    'Quantity': [10, 5, 2, 3, 4, 1],
    'Unit Price': [100, 150, 100, 200, 150, 100],
    'Revenue': [1000, 750, 200, 600, 600, 100]
}

df = pd.DataFrame(data)

# Chuyển đổi cột Date sang kiểu dữ liệu datetime
df['Date'] = pd.to_datetime(df['Date'])

print(df)
