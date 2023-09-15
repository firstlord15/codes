import flet as ft


def main(page):
    def button_clicked(e):
        output_text.value = f"Dropdown value is: {color_dropdown.value}"
        page.update()

    output_text = ft.Text()
    submit_btn = ft.ElevatedButton(text="Submit", on_click=button_clicked)
    color_dropdown = ft.Dropdown(
        width=200,
        options=[
            ft.dropdown.Option("Red"),
            ft.dropdown.Option("Green"),
            ft.dropdown.Option("Yellow"),
            ft.dropdown.Option("White"),
            ft.dropdown.Option("Black"),
        ],
    )

    page.add(color_dropdown, submit_btn, output_text)

ft.app(target=main)