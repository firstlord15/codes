import time
from conftest import *
from config import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage
from page_objects.RegistrationPage import RegistrationPage


def test_first_task(driver):
    time.sleep(3)
    MainPage(driver).click_product(0)
    ProductPage(driver).click_main_picture().right_arrow(3)


def test_second_task(driver):
    time.sleep(3)
    main_Page = MainPage(driver)
    main_Page.click_products_buy([0, 1]).click(MainPage.BUTTON_CART)
    time.sleep(3)


def test_third_task(driver):
    time.sleep(3)
    MainPage(driver).click(MainPage.DROPDOWN_PC).click(MainPage.LI_PC)
    time.sleep(3)


def test_forth_task(driver):
    time.sleep(3)
    MainPage(driver).open_registration()
    RegistrationPage(driver).registration().finish_reg()


def test_fifth_task(driver):
    time.sleep(3)
    MainPage(driver)._input(MainPage.INPUT_SEARCH, "random text!").enter()


# Доп тесты
def test_first_dop_task(driver):
    time.sleep(3)
    index = MainPage(driver).random(MainPage.PRODUCTS)
    MainPage(driver).click(MainPage.PRODUCTS_BUTTON_FAVORITE[index])


def test_second_dop_task(driver):
    time.sleep(3)
    MainPage(driver).click(MainPage(driver).LAST_INDEX)
    ProductPage(driver).click(ProductPage.SELECT_OPTION_COLOR).click(ProductPage.BUTTON_BUY)


def test_third_dop_task(driver):
    time.sleep(3)
    MainPage(driver).click(MainPage.DROPDOWN_TABLET).click(MainPage.PRODUCT_TABLET)
    ProductPage(driver).click(ProductPage.BUTTON_BUY)


def test_forth_dop_task(driver):
    time.sleep(3)
    MainPage(driver).click(MainPage.DROPDOWN_TELEPHONE_HTC).click(MainPage.PRODUCT_TELEPHONE_HTC)
    ProductPage(driver).click(ProductPage.BUTTON_BUY)


def test_fifth_dop_task(driver):
    time.sleep(3)
    MainPage(driver).click_product(0)
    
    product_page = ProductPage(driver)
    product_page.click(ProductPage.BUTTON_REVIEW)
    product_page._input(ProductPage.INPUT_NAME_REVIEW, firstname_text)
    product_page._input(ProductPage.INPUT_REVIEW, review_text)
    product_page.click_review_mark(4).click(ProductPage.BUTTON_NEXT_REVIEW)
    time.sleep(3)
