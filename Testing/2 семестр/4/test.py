import time
from conftest import *
from config import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage
from page_objects.RegistrationPage import RegistrationPage

def test_fifth_dop_task(driver):
    time.sleep(3)
    MainPage(driver).click_product(0)
    product_page = ProductPage(driver)
    product_page.click(ProductPage.BUTTON_REVIEW)
    product_page._input(ProductPage.INPUT_NAME_REVIEW, firstname_text)
    product_page._input(ProductPage.INPUT_REVIEW, review_text)
    product_page.click_review_mark(4).click(ProductPage.BUTTON_NEXT_REVIEW)
    time.sleep(3)