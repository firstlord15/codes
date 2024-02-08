from page_objects.BasePage import BasePage
from selenium.webdriver.common.by import By
from config import *

class MainPage(BasePage):
    SEARCH = (By.CSS_SELECTOR, "div.container div.row div.col-sm-5 div.input-group > input.form-control.input-lg")
    BASKET_lIST = (By.CSS_SELECTOR, "#cart-total")
    REGISTER = (By.LINK_TEXT, "Регистрация")
    LOGIN = (By.LINK_TEXT, "Авторизация")
    HOME = (By.LINK_TEXT, "Интернет магазин Opencart")
    PRODUCTS = [
        (By.CSS_SELECTOR, product.format("1", product_element)),
        (By.CSS_SELECTOR, product.format("2", product_element)),
        (By.CSS_SELECTOR, product.format("3", product_element)),
        (By.CSS_SELECTOR, product.format("4", product_element))
    ]

    PRODUCTS_BUTTON = [
        (By.CSS_SELECTOR, product.format("1", product_button)),
        (By.CSS_SELECTOR, product.format("2", product_button)),
        (By.CSS_SELECTOR, product.format("3", product_button)),
        (By.CSS_SELECTOR, product.format("4", product_button))
    ]

    

    

    
    

