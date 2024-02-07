# сайт
website = "https://demo-opencart.ru"

# данные сайта
layout_product_cssSelector = "div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(1) div.product-thumb.transition div.image > a:nth-child(1)"
photo_product_cssSelector = "div.container:nth-child(4) div.row div.col-sm-12 div.row div.col-sm-8 ul.thumbnails li:nth-child(1) > a.thumbnail"
home_button_cssSelector = "div.container div.row div.col-sm-4 div:nth-child(1) h1:nth-child(1) > a:nth-child(1)"

pc_button_cssSelector = "div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(1) > a.dropdown-toggle"
pc_button_li_cssSelector = "div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(1) div.dropdown-menu div.dropdown-inner ul.list-unstyled li:nth-child(1) > a:nth-child(1)"

registration_button_cssSelector = "div.container div.nav.pull-right ul.list-inline li.dropdown:nth-child(2) > a.dropdown-toggle"
registration_li_button_text = "Регистрация"
login_li_button_text = "Авторизация"

firstname_cssSelector = "#input-firstname"
lastname_cssSelector = "#input-lastname"
email_cssSelector = "#input-email"
password_cssSelector = "#input-password"
telephone_cssSelector = "#input-telephone"

firstname_text = "Ратмир"
lastname_text = "Ашимов"
email_text = "ratmir.yuldashev28@mail.ru"
telephone_text = "89096895085"
password_text = "UwUPassword"

registration_inputs = [firstname_cssSelector, lastname_cssSelector, email_cssSelector, telephone_cssSelector, password_cssSelector, "#input-confirm", "//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"]
registration_finished = "//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"
registration_input_texts = [firstname_text, lastname_text, email_text, telephone_text, password_text, password_text]

search_cssSelector = "div.container div.row div.col-sm-5 div.input-group > input.form-control.input-lg"
search_text = ["MacBook", "iPhone", "Apple Cinema 30", "Canon EOS 5D", "Random Text"]

MacBook_in_basket_cssSelector = "div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(1) div.product-thumb.transition div.button-group > button:nth-child(1)"
basket_xpath = "//body/nav[@id='top']/div[1]/div[1]/ul[1]/li[4]/a[1]"