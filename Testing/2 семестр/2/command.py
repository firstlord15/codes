import time
from config import *
from selenium.webdriver.common.by import By
from random import randint

from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def escape(driver):
    return ActionChains(driver).send_keys(Keys.ESCAPE).perform()

def enter(driver):
    return ActionChains(driver).send_keys(Keys.ENTER).perform()

# функция возврата на главную страницу
def home(driver):
    escape(driver)
    time.sleep(1)
    findElementClick(driver, home_button_cssSelector)

# указать курсор на что-то и потом нажать на второе 
def hover_mouse(first, second, driver):
    hover = driver.find_element(By.CSS_SELECTOR, first)  # Наведение мыши
    hover = ActionChains(driver).move_to_element(hover).perform()
    driver.find_element(By.CSS_SELECTOR, second).click() # клик по пункту

# заполняет поле, текстом, вставить можно как и просто текст, так и массив текстов
def write(text, input_field):
    result_text = text[randint(0, len(text) - 1)] if isinstance(text, list) else text
    for letter in result_text:
        time.sleep(randint(1, 5) / 50)
        input_field.send_keys(letter)
    time.sleep(1)

# нажатие -> столько раз, сколько указано
def right_arrow(count: int, driver):
    action_chains = ActionChains(driver)

    if (count < 0 | count == 1):
        action_chains.send_keys(Keys.CONTROL).send_keys(Keys.ARROW_RIGHT).perform()
    else:
        for _ in range(count):
            action_chains.send_keys(Keys.CONTROL).send_keys(Keys.ARROW_RIGHT).perform()
            time.sleep(1)
    
    time.sleep(1)

# находит и возвращает указанный элемент
def findElement(driver, cssSelector):
    return driver.find_element(By.CSS_SELECTOR, cssSelector)

# находит и нажимает на указанный элемент
def findElementClick(driver, cssSelector):
    element = driver.find_element(By.CSS_SELECTOR, cssSelector)
    element.click()
    time.sleep(1)

def findLTextClick(driver, Link_Text):
    element = driver.find_element(By.LINK_TEXT, Link_Text)
    element.click()
    time.sleep(1)

def findNameClick(driver, Name):
    element = driver.find_element(By.NAME, Name)
    element.click()
    time.sleep(1)

def findXpathClick(driver, Xpath):
    element = driver.find_element(By.XPATH, Xpath)
    element.click()
    time.sleep(1)
