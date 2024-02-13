import time
from conftest import *
from config import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage
from page_objects.RegistrationPage import RegistrationPage
from page_objects.CartPage import CartPage
from selenium.webdriver.common.by import By

def first_task(driver):
    time.sleep(1)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.PRODUCTS[0])
    time.sleep(1)
    
    productPage = ProductPage(driver)
    productPage.click(ProductPage.MAIN_PICTURE)
    time.sleep(1)
    productPage.right_arrow(3)
    time.sleep(2)

def second_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.PRODUCTS_BUTTON_BUY[0])
    mainPage.click(MainPage.PRODUCTS_BUTTON_BUY[1])
    mainPage.click(MainPage.BUTTON_CART)
    time.sleep(3)

def third_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.DROPDOWN_PC)
    mainPage.click(MainPage.LI_PC)
    time.sleep(3)

def forth_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.BUTTON_REGLOG)
    mainPage.click(MainPage.BUTTON_REGISTER)
    time.sleep(3)

    registrationPage = RegistrationPage(driver)
    registrationPage.registration()
    registrationPage.click(RegistrationPage.BUTTON_TRUE_SUBNEWS)
    registrationPage.click(RegistrationPage.BUTTON_ACCEPTANCE)
    registrationPage.click(RegistrationPage.BUTTON_NEXT)
    time.sleep(3)

def fifth_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage._input(MainPage.INPUT_SEARCH, "random text!")
    mainPage.enter()
    time.sleep(3)


# Доп тесты
def first_dop_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    index = mainPage.random(MainPage.PRODUCTS)
    mainPage.click(MainPage.PRODUCTS_BUTTON_FAVORITE[index])
    time.sleep(3)

def second_dop_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.PRODUCTS[MainPage.LAST_INDEX])
    
    productPage = ProductPage(driver)
    productPage.click(ProductPage.SELECT_OPTION_COLOR)
    productPage.click(ProductPage.BUTTON_BUY)

def third_dop_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.DROPDOWN_TABLET)
    mainPage.click(MainPage.PRODUCT_TABLET)
    
    productPage = ProductPage(driver)
    productPage.click(ProductPage.BUTTON_BUY)

def forth_dop_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.DROPDOWN_TELEPHONE_HTC)
    mainPage.click(MainPage.PRODUCT_TELEPHONE_HTC)
    
    productPage = ProductPage(driver)
    productPage.click(ProductPage.BUTTON_BUY)

def test_fifth_dop_task(driver):
    time.sleep(3)
    mainPage = MainPage(driver)
    mainPage.click(MainPage.PRODUCTS[0])

    productPage = ProductPage(driver)
    productPage.click(ProductPage.BUTTON_REVIEW)
    productPage._input(ProductPage.INPUT_NAME_REVIEW, firstname_text)
    productPage._input(ProductPage.INPUT_REVIEW, review_text)
    productPage.click(ProductPage.BUTTON_REVIEW_MARK[4])
    productPage.click(ProductPage.BUTTON_NEXT_REVIEW)
    time.sleep(3)
