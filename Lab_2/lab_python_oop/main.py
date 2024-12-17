from rectangle import Rectangle
from circle import Circle
from square import Square


if __name__ == '__main__':
    N = 13

    rectangle = Rectangle(N, N, "синий")
    print(rectangle)

    circle = Circle(N, "зеленый")
    print(circle)

    square = Square(N, "красный")
    print(square)

    import datetime

    print("Текущее время:", datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))