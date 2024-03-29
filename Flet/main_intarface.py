import flet as ft


def main(page):
    datatable = ft.DataTable(
            columns=[
                ft.DataColumn(ft.Text("ID")),
                ft.DataColumn(ft.Text("Title_status_log")),
                ft.DataColumn(ft.Text("Ip_address")),
                ft.DataColumn(ft.Text("Request_time")),
                ft.DataColumn(ft.Text("Request_path")),
                ft.DataColumn(ft.Text("Status_code")),
                ft.DataColumn(ft.Text("Response_size")),
            ],
            rows=[
                ft.DataRow(
                    cells=[
                        ft.DataCell(ft.Text()),
                    ],
                ),
            ],
        )
    btn_date_sort = ft.ElevatedButton(text="Сортировка по дате", width=500)
    btn_ip_sort = ft.ElevatedButton(text="Сортировка по IP", width=500)
    list = ["red", "white", "blue"]
    ip_dropdown = ft.Dropdown()
    for elements in list:
        ip_dropdown.options.append(ft.dropdown.Option(elements))

    active = ft.ElevatedButton(text="Применить фильтр", width=500)
    save_json_file = ft.ElevatedButton(text="Сохранить в json файле", width=500)

    page.add(ft.Column([datatable, btn_ip_sort, btn_date_sort, active, save_json_file]), ip_dropdown)


ft.app(target=main)
