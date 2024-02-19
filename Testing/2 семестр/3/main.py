import time
from conftest import *
from config import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage
from page_objects.RegistrationPage import RegistrationPage


def test_first_task(driver):
    time.sleep(1)
    main_page = MainPage(driver)
    main_page.click(MainPage.PRODUCTS[0])
    time.sleep(1)
    product_page = ProductPage(driver)
    product_page.click(ProductPage.MAIN_PICTURE)
    time.sleep(1)
    product_page.right_arrow(3)
    time.sleep(2)


def test_second_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.PRODUCTS_BUTTON_BUY[0])
    main_page.click(MainPage.PRODUCTS_BUTTON_BUY[1])
    main_page.click(MainPage.BUTTON_CART)
    time.sleep(3)


def test_third_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.DROPDOWN_PC)
    main_page.click(MainPage.LI_PC)
    time.sleep(3)


def test_forth_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.BUTTON_REGLOG)
    main_page.click(MainPage.BUTTON_REGISTER)
    time.sleep(3)
    registration_page = RegistrationPage(driver)
    registration_page.registration()
    registration_page.click(RegistrationPage.BUTTON_TRUE_SUBNEWS)
    registration_page.click(RegistrationPage.BUTTON_ACCEPTANCE)
    registration_page.click(RegistrationPage.BUTTON_NEXT)
    time.sleep(3)


def test_fifth_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page._input(MainPage.INPUT_SEARCH, "random text!")
    main_page.enter()
    time.sleep(3)


# Доп тесты
def test_first_dop_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    index = main_page.random(MainPage.PRODUCTS)
    main_page.click(MainPage.PRODUCTS_BUTTON_FAVORITE[index])
    time.sleep(3)


def test_second_dop_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.PRODUCTS[MainPage.LAST_INDEX])
    product_page = ProductPage(driver)
    product_page.click(ProductPage.SELECT_OPTION_COLOR)
    product_page.click(ProductPage.BUTTON_BUY)


def test_third_dop_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.DROPDOWN_TABLET)
    main_page.click(MainPage.PRODUCT_TABLET)
    product_page = ProductPage(driver)
    product_page.click(ProductPage.BUTTON_BUY)


def test_forth_dop_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.DROPDOWN_TELEPHONE_HTC)
    main_page.click(MainPage.PRODUCT_TELEPHONE_HTC)
    product_page = ProductPage(driver)
    product_page.click(ProductPage.BUTTON_BUY)


def test_fifth_dop_task(driver):
    time.sleep(3)
    main_page = MainPage(driver)
    main_page.click(MainPage.PRODUCTS[0])
    product_page = ProductPage(driver)
    product_page.click(ProductPage.BUTTON_REVIEW)
    product_page._input(ProductPage.INPUT_NAME_REVIEW, firstname_text)
    product_page._input(ProductPage.INPUT_REVIEW, review_text)
    product_page.click(ProductPage.BUTTON_REVIEW_MARK[4])
    product_page.click(ProductPage.BUTTON_NEXT_REVIEW)
    time.sleep(3)
