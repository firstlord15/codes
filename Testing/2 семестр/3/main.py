import time
from conftest import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage

def test_first_task(driver):
    mainPage = MainPage(driver)
    # time.sleep(2)
    # mainPage._input(MainPage.SEARCH, "random text")
    # mainPage.enter()
    # time.sleep(2)
    # for i in range(len(mainPage.PRODUCTS)):
    #     time.sleep(1)
    #     mainPage.click(mainPage.PRODUCTS[i])
    #     time.sleep(1)
    #     mainPage.click(mainPage.HOME)
    # time.sleep(2)
    
    productPage = ProductPage(driver)
    mainPage.click(MainPage.PRODUCTS[0])

    time.sleep(2)
    productPage.click(ProductPage.CHARACTERISTICS)
    time.sleep(2)
    productPage.click(ProductPage.DESCRIPTION)
    time.sleep(2)
    productPage.click(ProductPage.FEEDBACK)

    time.sleep(2)
    productPage._input(ProductPage.INPUT_COUNT, "4")

    time.sleep(2)
    productPage.click(ProductPage.BUTTON_BUY)
    time.sleep(4)


    