import time
import flet as ft


def main(page: ft.Page):
    # t = ft.Text(value="Hello, world!", color="green")
    # page.controls.append(t)
    # page.update()

    t = ft.Text()
    page.add(t)

    for i in range(10):
        t.value = f"Step {i}"
        page.update()
        time.sleep(1)

ft.app(target=main, view=ft.FLET_APP_WEB)
