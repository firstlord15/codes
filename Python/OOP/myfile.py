from math import sin, cos, radians
from typing import Tuple
import abc


class Logger(abc.ABC):
    @abc.abstractmethod
    def log(self, message: str):
        pass


class LogToConsole(Logger):
    def log(self, message: str):
        print(message)


class Plotter:
    def __init__(self, logger):
        self.logger = logger
        self.color = 'Black'
        self.position = (0, 0)
        self.is_pen_down = False
        self.direction = 0

    def set_color(self, color: str):
        self.color = color
        self.logger.log(f"Устанавливаем {color.lower()} цвет линии.")

    def move(self, distance: float):
        x, y = self.position
        dx, dy = distance * cos(radians(self.direction)), distance * sin(radians(self.direction))
        new_position = (x + dx, y + dy)

        if self.is_pen_down:
            self.draw_line(self.position, new_position)

        self.position = new_position
        self.logger.log(
            f'Чертим линию из {self.position_str(self.position)} в {self.position_str(new_position)} используя {self.color.lower()} цвет.')

    def turn(self, angle: float):
        self.direction += angle
        self.logger.log(f"Поворачиваем на {angle} градусов.")

    def carriage_up(self):
        self.is_pen_down = False
        self.logger.log("Поднимаем каретку.")

    def carriage_down(self):
        self.is_pen_down = True
        self.logger.log("Опускаем каретку.")

    def set_position(self, x: float, y: float):
        self.position = (x, y)
        self.logger.log(f"Устанавливаем начальную позицию каретки в {self.position_str(self.position)}.")

    def position_str(self, position: Tuple[float, float]):
        return f"({position[0]:.0f}, {position[1]:.0f})"

    def draw_line(self, start: Tuple[float, float], end: Tuple[float, float]):
        pass


def draw_triangle(plotter, size):
    plotter.set_color('Green')
    for _ in range(2):
        plotter.carriage_down()
        plotter.move(size)
        plotter.carriage_up()
        plotter.turn(120.0)


plotter = Plotter(LogToConsole())
draw_triangle(plotter, 100.0)
