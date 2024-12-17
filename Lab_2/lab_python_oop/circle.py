import math
from geometric_figure import GeometricFigure
from figure_color import FigureColor


class Circle(GeometricFigure):
    name = "Круг"

    def __init__(self, radius, color):
        self.radius = radius
        self.color = FigureColor(color)

    def area(self):
        return math.pi * self.radius ** 2

    def __repr__(self):
        return "Фигура: {0}, Цвет: {1}, Радиус: {2}, Площадь: {3:.2f}".format(
            self.name, self.color.color(), self.radius, self.area()
        )
