import time
from config import *
from command import *

from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService

driver = webdriver.Chrome(service=ChromeService())
driver.get("https://demo-opencart.ru")

def first_task():    
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
    findElementClick(driver, registration_li_button_cssSelector)

    # для заполнения полей в регистрации данными
    for i in range(0, len(registration_input_texts)):
        input = driver.find_element(By.CSS_SELECTOR, registration_inputs[i])
        input.click()
        write(registration_input_texts[i], input, driver)

    findElementClick(driver, registration_inputs[-3])
    findElementClick(driver, registration_inputs[-2])

    # для проверки, был ли такой аккаунт или нет
    try:
        findElementClick(driver, registration_inputs[-1])
        time.sleep(2)
        home(driver)
    except:
        home(driver)

    time.sleep(3)


    
    


forth_task()