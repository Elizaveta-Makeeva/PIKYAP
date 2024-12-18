import sys
import math


class Coefficient:
    def __init__(self, index, prompt):
        self.index = index
        self.prompt = prompt
        self.value = self.get_coef()

    def get_coef(self):
        try:
            coef_str = sys.argv[self.index]
            return float(coef_str)
        except (IndexError, ValueError):
            print(self.prompt)
            while True:
                try:
                    coef_str = input()
                    return float(coef_str)
                except ValueError:
                    print("Пожалуйста, введите действительное число.")


class BiQuadraticEquation:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c
        self.roots = []

    def get_discriminant(self):
        return self.b ** 2 - 4 * self.a * self.c

    def get_roots(self):
        if self.a == 0:
            print("Уравнение не является биквадратным.")
            return []

        discriminant = self.get_discriminant()
        if discriminant < 0:
            return []

        y1 = (-self.b + math.sqrt(discriminant)) / (2 * self.a)
        y2 = (-self.b - math.sqrt(discriminant)) / (2 * self.a)

        roots = set()
        if y1 >= 0:
            roots.add(math.sqrt(y1))
            roots.add(-math.sqrt(y1))
        if y2 >= 0 and y1 != y2:
            roots.add(math.sqrt(y2))
            roots.add(-math.sqrt(y2))
        self.roots = list(roots)

    def display_roots(self):
        self.get_roots()
        len_roots = len(self.roots)
        if len_roots == 4:
            print(f"Уравнение имеет четыре действительных корня: {self.roots[0]}, {self.roots[1]}, {self.roots[2]} и {self.roots[3]}")
        elif len_roots == 3:
            print(f"Уравнение имеет три действительных корня: {self.roots[0]}, {self.roots[1]} и {self.roots[2]}")
        elif len_roots == 2:
            print(f"Уравнение имеет два действительных корня: {self.roots[0]} и {self.roots[1]}")
        elif len_roots == 1:
            print(f"Уравнение имеет один действительный корень: {self.roots[0]}")
        else:
            print("Уравнение не имеет действительных корней.")


def main():
    a = Coefficient(1, 'Введите коэффициент A:').value
    b = Coefficient(2, 'Введите коэффициент B:').value
    c = Coefficient(3, 'Введите коэффициент C:').value

    equation = BiQuadraticEquation(a, b, c)
    equation.display_roots()


if __name__ == "__main__":
    main()
