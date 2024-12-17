from geometric_figure import GeometricFigure
from figure_color import FigureColor


class Rectangle(GeometricFigure):
    name = "Прямоугольник"

    def __init__(self, width, height, color):
        self.width = width
        self.height = height
        self.color = FigureColor(color)

    def area(self):
        return self.width * self.height

    def __repr__(self):
        return "Фигура: {0}, Цвет: {1}, Ширина: {2}, Высота: {3}, Площадь: {4}".format(
            self.name, self.color.color(), self.width, self.height, self.area()
        )
