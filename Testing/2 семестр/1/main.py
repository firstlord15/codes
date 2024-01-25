import time
from random import randint
from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService

driver = webdriver.Chrome(service=ChromeService())
driver.get("https://konflic.github.io/examples/")

input_field = driver.find_element(By.CSS_SELECTOR, "#inp")
inp_form = driver.find_element(By.CSS_SELECTOR, "#inp_form")
text = "Давид Дебил!"
 
input_field.click()
input_field.clear()
for letter in text:
    time.sleep(randint(1, 3)/10)
    input_field.send_keys(letter)
time.sleep(1)

inp_form.click()
inp_form.clear()
for letter in text:
    time.sleep(randint(1, 3)/10)
    inp_form.send_keys(letter)


div = driver.find_element(By.CSS_SELECTOR, "div.margins:nth-child(6) table.table.table-bordered tbody:nth-child(1) tr:nth-child(3) > td:nth-child(1)")

div.click()
time.sleep(1)
div.click()
time.sleep(1)
div.click()
time.sleep(1)
div.click()





time.sleep(3)

driver.quit()