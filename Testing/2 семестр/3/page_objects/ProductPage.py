from page_objects.BasePage import BasePage
from selenium.webdriver.common.by import By
from config import *

class ProductPage(BasePage):
    MAIN_PICTURE = (By.CSS_SELECTOR, "div.container:nth-child(4) div.row div.col-sm-12 div.row div.col-sm-8 ul.thumbnails li:nth-child(1) > a.thumbnail")
    BUTTON_FAVORITE = (By.CSS_SELECTOR, "div.container:nth-child(4) div.row div.col-sm-12 div.row div.col-sm-4 div.btn-group:nth-child(1) > button.btn.btn-default:nth-child(1)")
    BUTTON_BUY = (By.CSS_SELECTOR, "#button-cart")
    INPUT_COUNT = (By.CSS_SELECTOR, "#input-quantity")
    DESCRIPTION = (By.LINK_TEXT, "Описание")
    CHARACTERISTICS = (By.LINK_TEXT, "Характеристики")
    FEEDBACK = (By.PARTIAL_LINK_TEXT, "Отзывов (")


