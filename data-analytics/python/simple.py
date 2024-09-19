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

print("For loop:")
for i in range(3):
    print(i)


def greet():
    return "Hello"
