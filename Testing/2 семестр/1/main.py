from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium import webdriver

options = Options()
service = Service()
browser = webdriver.Chrome(service=service, options = options)
options = Options()
browser.get("https://www.google.com")
assert browser.title == "Google"
browser.quit()