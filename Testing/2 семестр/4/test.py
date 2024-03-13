import time
from conftest import *
from config import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage
from page_objects.RegistrationPage import RegistrationPage


@allure.feature("Search")
@allure.title("Input text in search")
def test_third_dop_task(driver):
    time.sleep(3)
    MainPage(driver).click(MainPage.DROPDOWN_TABLET)
    MainPage(driver).click(MainPage.PRODUCT_TABLET)
    ProductPage(driver).click(ProductPage.BUTTON_BUY)
