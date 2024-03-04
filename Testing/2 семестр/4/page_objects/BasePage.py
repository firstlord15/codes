from selenium.webdriver import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

from random import randint
import time


class BasePage:
    def __init__(self, driver, wait=10):
        self.driver = driver
        self.logger = driver.logger
        self.wait =  WebDriverWait(self.driver, wait)

    def is_tuple(self, element_locator):
        if isinstance(element_locator, tuple):
            return self.driver.find_element(*element_locator)
        else:
            return self.driver.find_element(element_locator)

    def escape(self):
        ActionChains(self.driver).send_keys(Keys.ESCAPE).perform()
        time.sleep(2)
        return self

    def enter(self):
        ActionChains(self.driver).send_keys(Keys.ENTER).perform()
        time.sleep(2)
        return self

    @staticmethod
    def random(arr):
        return randint(0, len(arr) - 1)

    @staticmethod
    def last(arr):
        return len(arr) - 1

    def click(self, element_locator):
        try:
            time.sleep(1)
            element = self.is_tuple(element_locator)
            self.wait.until(EC.element_to_be_clickable(element)).click()
            # ActionChains(self.driver).move_to_element(element).click().perform()
            time.sleep(1)
        except Exception as e:
            print(f"Ошибка при выполнении клика: {e}")

        return self

    def write(self, element_locator, value):
        element = self.is_tuple(element_locator)
        element.clear()

        result_text = value[randint(0, len(value) - 1)] if isinstance(value, list) else value

        for letter in result_text:
            time.sleep(randint(1, 3) / 50)
            element.send_keys(letter)
        time.sleep(1)

        return self

    def _input(self, element, value):
        self.click(element).write(element, value)
        time.sleep(2)

        return self
