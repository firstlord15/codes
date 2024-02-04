import time
from config import *
from command import *
from conftest import *

from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService

driver = driver()
driver.get("https://demo-opencart.ru")

def first_task():
    time.sleep(3)    
    findElementClick(driver, layout_product_cssSelector)
    findElementClick(driver, photo_product_cssSelector)

    # нажатие -> столько раз, сколько указано
    right_arrow(3, driver)
    home(driver)

def second_task():
    # в сайте нет смены валюты
    pass

def third_task():
    hover_mouse(pc_button_cssSelector, pc_button_li_cssSelector, driver)
    time.sleep(4)

    home(driver)

def forth_task():
    time.sleep(2)
    findElementClick(driver, registration_button_cssSelector)
    findLTextClick(driver, registration_li_button_cssSelector)

    # для заполнения полей в регистрации данными
    for i in range(0, len(registration_input_texts)):
        input = findElement(driver, registration_inputs[i])
        input.click()
        write(registration_input_texts[i], input)

    findXpathClick(driver, registration_inputs[-1])
    findXpathClick(driver, registration_finished)
    time.sleep(2)

    home(driver)
    time.sleep(3)


def fifth_task():
    search = findElement(driver, search_cssSelector)
    time.sleep(1)
    search.click()
    time.sleep(10)
    write(search_text, search)
    time.sleep(1)
    enter(driver)

# first_task()
# second_task()
# third_task()
# forth_task()
# fifth_task()