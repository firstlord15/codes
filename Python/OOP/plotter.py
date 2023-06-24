import math, toolz
from typing import NewType, Literal, Callable, NamedTuple

# Плоттер поддерживает четыре команды:

# 1. Переместить каретку на некоторое расстояние в текущем направлении.
# 2. Повернуть на определенное количество градусов по часовой стрелке или против часовой стрелки.
# 3. Опустить или поднять каретку. Когда каретка опущена, плоттер при перемещении рисует линию.
# 4. Установить цвет линии (один из черного, красного или зелёного).

Point = NewType('Point', float)
Distance = NewType('Distance', float)
Angle = NewType('Angle', float)
Position = NamedTuple('Position', [('x', Point), ('y', Point)])
CarriageState = Literal['UP', 'DOWN']
LineColor = Literal['Black', 'Red', 'Green']
PlotterState = NamedTuple('PlotterState',
                          [
                              ("position", Position),
                              ("angle", Angle),
                              ("color", LineColor),
                              ("carriageState", CarriageState)
                          ]
)


##################################################
def calc_new_position(distance: Distance, angle: Angle, current_pos: Position) -> Position:
    # Преобразуем градусы в радианы при 180.0 градусов = 1 pi радиан
    angle_in_rads = math.radians(angle)
    # новая позиция
    x = current_pos.x + (distance * math.cos(angle_in_rads))
    y = current_pos.y + (distance * math.sin(angle_in_rads))
    # возвращаем новую позицию
    new_x = Point(round(x, 2))
    new_y = Point(round(y, 2))
    return Position(x=new_x, y=new_y)


def draw_line(log: Callable, pos_from: Position, pos_to, color: LineColor) -> None:
    # Типа чертим линию
    log(f"...Чертим линию из {pos_from} в {pos_to} используя цвет {color}")


@toolz.curry
def move(log: Callable, distance: Distance, state: PlotterState) -> PlotterState:
    log(f"Передвигаем на {distance} от точки {state.position}")
    # вычисляем новую позицию
    new_position = calc_new_position(distance, state.angle, state.position)
    # если нужно, рисуем линию
    if state.carriageState == 'DOWN':
        # Здесь следует отрисовка линии
        draw_line(log, state.position, new_position, state.color)
    # изменяем состояние
    return state._replace(position=new_position)


@toolz.curry
def turn(log: Callable, angle: Angle, state: PlotterState) -> PlotterState:
    log(f"Поворачиваем на {angle} градусов")
    # вычисляем новый угол
    new_angle = (state.angle + angle) % 360.0
    # изменяем состояние
    return state._replace(angle=Angle(new_angle))


@toolz.curry
def carriage_up(log: Callable, state: PlotterState) -> PlotterState:
    log("Поднимаем каретку")
    # изменяем состояние
    return state._replace(carriageState='UP')


@toolz.curry
def carriage_down(log: Callable, state: PlotterState) -> PlotterState:
    log("Опускаем каретку")
    # изменяем состояние
    return state._replace(carriageState='DOWN')


@toolz.curry
def set_color(log: Callable, color: LineColor, state: PlotterState) -> PlotterState:
    log(f"Устанавливаем цвет линии в {color}")
    # изменяем состояние
    return state._replace(color=color)


def log(message: str) -> None:
    print(message)


# каррируем функции
move = move(log)
turn = turn(log)
carriage_down = carriage_down(log)
carriage_up = carriage_up(log)
set_color = set_color(log)


def initialize_plotter_state(position: Position, angle: Angle, color: LineColor,
                             carriage_state: CarriageState) -> PlotterState:
    return PlotterState(
        position=position,
        angle=angle,
        color=color,
        carriageState=carriage_state
    )


init_position: Position = Position(x=Point(0.0), y=Point(0.0))
init_color: LineColor = "Black"
init_carriage_state: CarriageState = "DOWN"
plotter_state = initialize_plotter_state(init_position, Angle(0.0), init_color, init_carriage_state)
##################################################
if __name__ == "__main__":
    def draw_triangle(state: PlotterState):
        toolz.pipe(state,
                   carriage_down,
                   move(100.0),
                   turn(120.0),
                   move(100.0),
                   turn(120.0),
                   move(100.0),
                   turn(120.0))


    draw_triangle(plotter_state)
