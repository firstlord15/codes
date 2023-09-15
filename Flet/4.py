import flet as ft


def main(page):
    name_task = ft.TextField(hint_text="First name", autofocus=True)
    surname_task = ft.TextField(hint_text="Last name")
    greetings = ft.Column()

    def say_hello_btn(e):
        greetings.controls.append(ft.Text(f"Hello, {name_task.value} {surname_task.value}"))
        name_task.value = ""
        surname_task.value = ""
        page.update()
        name_task.focus()

    page.add(
        name_task,
        surname_task,
        ft.ElevatedButton("Say hello", on_click=say_hello_btn),
        greetings,
    )


ft.app(target=main, view=ft.FLET_APP_WEB)
