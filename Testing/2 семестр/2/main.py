import time
from config import *
from command import *
from conftest import *

# driver = webdriver.Chrome()
# driver.get("https://demo-opencart.ru")

def first_task(driver):
    time.sleep(3)
    findElementClick(driver, layout_product_cssSelector)
    findElementClick(driver, photo_product_cssSelector)
    right_arrow(3, driver)
    home(driver)

def second_task(driver):
    # в сайте нет смены валюты
    pass

def third_task(driver):
    hover_mouse(pc_button_cssSelector, pc_button_li_cssSelector, driver)
    time.sleep(2)
    home(driver)

def forth_task(driver):
    time.sleep(2)
    findElementClick(driver, registration_button_cssSelector)
    findLTextClick(driver, registration_li_button_cssSelector)

    for i in range(len(registration_input_texts)):
        input = findElement(driver, registration_inputs[i])
        input.click()
        write(registration_input_texts[i], input)

    findXpathClick(driver, registration_inputs[-1])
    findXpathClick(driver, registration_finished)
    time.sleep(2)
    home(driver)
    time.sleep(3)


def test_fifth_task(driver):
    search = findElement(driver, search_cssSelector)
    write(search_text, search)
    enter(driver)
    time.sleep(3)
