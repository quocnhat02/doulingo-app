# Bối cảnh dự án:
# Bạn có một bộ dữ liệu bán hàng từ một cửa hàng, chứa các thông tin về ngày bán hàng, danh mục sản phẩm, số lượng bán, giá bán, và doanh thu.

# Mục tiêu:
# Tính toán các chỉ số doanh thu trung bình, tổng doanh thu theo danh mục sản phẩm.
# Xử lý dữ liệu bị thiếu.
# Tìm sản phẩm bán chạy nhất.
# Phân tích xu hướng doanh thu theo thời gian.

# Bước 1: Tạo dữ liệu bán hàng mẫu
# Sử dụng Pandas để tạo một DataFrame từ một dictionary với các cột như Date, Product, Category, Quantity, Unit Price, và Revenue.

import matplotlib.pyplot as plt
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

# Bước 2: Tính toán chỉ số tổng doanh thu và doanh thu trung bình
# Sử dụng Pandas để tính toán tổng doanh thu và doanh thu trung bình theo từng sản phẩm và từng danh mục sản phẩm.

# Tính tổng doanh thu theo sản phẩm:
# Tổng doanh thu theo sản phẩm
total_revenue_per_product = df.groupby('Product')['Revenue'].sum()
print("Total Revenue per Product:\n", total_revenue_per_product)

# Tính doanh thu trung bình theo danh mục sản phẩm:
# Doanh thu trung bình theo danh mục sản phẩm
avg_revenue_per_category = df.groupby('Category')['Revenue'].mean()
print("Average Revenue per Category:\n", avg_revenue_per_category)

# Bước 3: Xử lý dữ liệu bị thiếu (missing values)
# Giả sử trong bộ dữ liệu, có một số giá trị bị thiếu ở cột Revenue. Bạn có thể sử dụng các kỹ thuật như điền giá trị bị thiếu bằng giá trị trung bình hoặc giá trị mặc định.
# Giả sử có một số giá trị bị thiếu ở cột Revenue
df_missing = df.copy()
df_missing.loc[3, 'Revenue'] = None

# Điền giá trị thiếu bằng doanh thu trung bình của các sản phẩm
df_missing['Revenue'] = df_missing['Revenue'].fillna(
    df_missing['Revenue'].mean())

print("Data after handling missing values:\n", df_missing)

# Bước 4: Tìm sản phẩm bán chạy nhất
# Sử dụng hàm idxmax() để tìm sản phẩm có tổng doanh thu cao nhất.
# Tìm sản phẩm có doanh thu cao nhất
best_selling_product = df.groupby('Product')['Revenue'].sum().idxmax()
print(f"Best selling product: {best_selling_product}")

# Bước 5: Phân tích xu hướng doanh thu theo thời gian
# Sử dụng Pandas để nhóm dữ liệu theo ngày và tính tổng doanh thu cho từng ngày. Sau đó, sử dụng matplotlib để vẽ biểu đồ xu hướng doanh thu theo thời gian.

# Tính tổng doanh thu theo thời gian
revenue_by_date = df.groupby('Date')['Revenue'].sum()

# Vẽ biểu đồ doanh thu theo thời gian
plt.plot(revenue_by_date.index, revenue_by_date.values, marker='o')
plt.xlabel('Date')
plt.ylabel('Revenue')
plt.title('Revenue Trend Over Time')
plt.show()
