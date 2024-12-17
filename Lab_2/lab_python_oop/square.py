from rectangle import Rectangle


class Square(Rectangle):
    name = "Квадрат"

    def __init__(self, side, color):
        super().__init__(side, side, color)

    def __repr__(self):
        return "Фигура: {0}, Цвет: {1}, Сторона: {2}, Площадь: {3}".format(
            self.name, self.color.color(), self.width, self.area()
        )