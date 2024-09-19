# Show Variables & Keywords of Python

# Variables in Python
from functools import reduce
from abc import ABC, abstractmethod
import math
import keyword
x = 5           # Integer variable
y = 3.14        # Float variable
name = "Alice"  # String variable
is_active = True  # Boolean variable

# Keywords in Python
print("Python keywords:")
print(keyword.kwlist)

# Examples of using keywords
if x > 0:
    print("x is positive")
elif x == 0:
    print("x is zero")
else:
    print("x is negative")

n = 0
while n < 3:
    print(n)
    n += 1

# while loop (mimicking do-while behavior)
z = 0
while True:
    print(z)
    z += 1
    if z >= 3:
        break

score = 3
match score:
    case 1:
        print("Score is 1")
    case 2:
        print("Score is 2")
    case 3:
        print("Score is 3")
    case 4:
        print("Score is 4")
    case 5:
        print("Score is 5")
    case _:
        print("Score is not in the range of 1 to 5")

print("For loop:")
for i in range(3):
    print(i)


def greet():
    return "Hello"


# Datatypes Operators

# Integers
a = 10
b = 20
print("Addition:", a + b)
print("Subtraction:", a - b)
print("Multiplication:", a * b)
print("Division:", a / b)

# Floats
x = 3.14
y = 2.71
print("Addition:", x + y)
print("Subtraction:", x - y)
print("Multiplication:", x * y)
print("Division:", x / y)

# Strings
name = "Alice"
print("Length of name:", len(name))
print("Uppercase:", name.upper())
print("Lowercase:", name.lower())
print("Substring:", name[2:4])

# Booleans
is_true = True
is_false = False
print("AND:", is_true and is_false)
print("OR:", is_true or is_false)
print("NOT:", not is_true)

# Lists
numbers = [1, 2, 3, 4, 5]
print("First number:", numbers[0])
print("Last number:", numbers[-1])

# Tuples
# Tuples là một dạng dữ liệu có thể lưu trữ nhiều giá trị khác nhau trong một đối tượng duy nhất.
# Tuples khác Sets là các giá trị trong tuple được phân biệt bởi dấu phẩy và được đặt trong dấu ngoặc đơn.
# Tuples khác Lists là các giá trị trong tuple được phân biệt bởi dấu phẩy và được đặt trong dấu ngoặc đơn.
coordinates = (10, 20)
print("X coordinate:", coordinates[0])
print("Y coordinate:", coordinates[1])

# Dictionaries
# Dictionaries là một dạng dữ liệu có thể lưu trữ nhiều giá trị khác nhau trong một đối tượng duy nhất.
# Các giá trị trong dictionary được phân biệt bởi dấu phẩy và được đặt trong dấu ngoặc nhọn.
person = {"name": "Alice", "age": 25, "city": "New York"}
print("Name:", person["name"])

# Sets
# Sets là một dạng dữ liệu có thể lưu trữ nhiều giá trị khác nhau trong một đối tượng duy nhất.
# Sets khác Lists là các giá trị trong set được phân biệt bởi dấu phẩy và được đặt trong dấu ngoặc nhọn.
unique_numbers = {1, 2, 3, 4, 5}
print("First number:", unique_numbers)

# Typecasting
# Typecasting là quá trình chuyển đổi kiểu dữ liệu từ một kiểu dữ liệu này sang kiểu dữ liệu khác.
num_str = "123"
num_int = int(num_str)
print("Number:", num_int)

# Map Reducing Filter
# Map là quá trình áp dụng một hàm cho từng phần tử trong một đối tượng duy nhất.
numbers = [1, 2, 3, 4, 5]
# Lambda là một hàm không có tên được định nghĩa ngay tại vị trí sử dụng.
squared_numbers = list(map(lambda x: x**2, numbers))
print("Squared numbers:", squared_numbers)

# Reduce là quá trình áp dụng một hàm cho từng phần tử trong một đối tượng duy nhất.
numbers = [1, 2, 3, 4, 5]
sum_of_numbers = reduce(lambda x, y: x + y, numbers)
print("Sum of numbers:", sum_of_numbers)

# Filter là quá trình áp dụng một hàm cho từng phần tử trong một đối tượng duy nhất.
numbers = [1, 2, 3, 4, 5]
even_numbers = list(filter(lambda x: x % 2 == 0, numbers))
print("Even numbers:", even_numbers)

# Input and Output
# Input là dữ liệu được nhập vào từ bàn phím.
# Output là dữ liệu được xuất ra từ màn hình.
name = input("Enter your name: ")
print("Hello,", name)

# File Handling
# File Handling là quá trình đọc và ghi dữ liệu từ file.
with open("example.txt", "w") as file:
    file.write("Hello, World!")

with open("example.txt", "r") as file:
    print(file.read())

# Exception Handling
# Exception Handling là quá trình xử lý các lỗi trong code.
try:
    num = int(input("Enter a number: "))
    print("Number:", num)
except ValueError:
    print("Invalid input")

# Modules
# Modules là các file chứa code được sử dụng để mở rộng chức năng của Python.
print("Square root:", math.sqrt(16))

# Classes and Objects
# Classes là một dạng dữ liệu có thể lưu trữ nhiều giá trị khác nhau trong một đối tượng duy nhất.
# Các giá trị trong class được phân biệt bởi dấu phẩy và được đặt trong dấu ngoặc nhọn.


class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def greet(self):
        return "Hello, my name is", self.name


person = Person("Alice", 25)
print(person.greet())

# Inheritance

# 1 Class có thể kế thừa từ nhiều class khác nhau.
# Tại vì python là nó hỗ trợ đa kế thừa.


class Student(Person):
    def __init__(self, name, age, grade):
        super().__init__(name, age)
        self.grade = grade

    def study(self):
        return "I am studying"


student = Student("Bob", 20, "A")
print(student.greet())

# Polymorphism


class Animal:
    def speak(self):
        return "Animal sound"


class Dog(Animal):
    def speak(self):
        return "Woof"


class Cat(Animal):
    def speak(self):
        return "Meow"


animals = [Dog(), Cat()]
for animal in animals:
    print(animal.speak())

# Encapsulation


class BankAccount:
    def __init__(self, balance):
        self.__balance = balance

    def deposit(self, amount):
        self.__balance += amount

    def withdraw(self, amount):
        if amount > self.__balance:
            return "Insufficient balance"
        self.__balance -= amount
        return "Withdrawal successful"


account = BankAccount(1000)
print(account.withdraw(500))
print(account.deposit(200))

# Abstraction


class Vehicle(ABC):
    @abstractmethod
    def start(self):
        pass


class Car(Vehicle):
    def start(self):
        return "Car engine started"


class Motorcycle(Vehicle):
    def start(self):
        return "Motorcycle engine started"


vehicles = [Car(), Motorcycle()]
for vehicle in vehicles:
    print(vehicle.start())
