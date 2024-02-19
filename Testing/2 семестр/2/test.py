from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Chrome()
driver.get("https://demo-opencart.ru")

kupit =  driver.find_element(By.LINK_TEXT, "MacBook")

time.sleep(2)
kupit.click()
time.sleep(4)