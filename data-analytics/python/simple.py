# Show Variables & Keywords of Python

# Variables in Python
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

for i in range(3):
    print(i)


def greet():
    return "Hello"
