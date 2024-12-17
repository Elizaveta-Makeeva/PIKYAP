import sys
import math


def get_coef(index, prompt):
    try:
        coef_str = sys.argv[index]
    except:
        print(prompt)
        coef_str = input()
    try:
        coef = float(coef_str)
    except ValueError:
        print("Введите три числа")
        coef = 0
    return coef


def get_roots(a, b, c):
    if a == 0:
        print("Уравнение не является биквадратным.")
        return []
    discriminant = b ** 2 - 4 * a * c
    if discriminant < 0:
        return []
    y1 = (-b + math.sqrt(discriminant)) / (2 * a)
    y2 = (-b - math.sqrt(discriminant)) / (2 * a)
    roots = set()
    if y1 >= 0:
        roots.add(math.sqrt(y1))
        roots.add(-math.sqrt(y1))
    if y2 >= 0 and y1 != y2:
        roots.add(math.sqrt(y2))
        roots.add(-math.sqrt(y2))
    return list(roots)


def main():
    a = get_coef(1, 'Введите коэффициент А:')
    b = get_coef(2, 'Введите коэффициент B:')
    c = get_coef(3, 'Введите коэффициент C:')
    roots = get_roots(a, b, c)
    if len(roots) == 4:
        print(f"Уравнение имеет четыре действительных корня: {roots[0]}, {roots[1]}, {roots[2]} и {roots[3]}")
    elif len(roots) == 3:
        print(f"Уравнение имеет три действительных корня: {roots[0]}, {roots[1]} и {roots[2]}")
    elif len(roots) == 2:
        print(f"Уравнение имеет два действительных корня: {roots[0]} и {roots[1]}")
    elif len(roots) == 1:
        print(f"Уравнение имеет один действительный корень: {roots[0]}")
    else:
        print("Уравнение не имеет действительных корней.")


if __name__ == "__main__":
    main()
