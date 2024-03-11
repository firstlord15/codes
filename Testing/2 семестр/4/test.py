import time
from conftest import *
from config import *
from page_objects.MainPage import MainPage
from page_objects.ProductPage import ProductPage
from page_objects.RegistrationPage import RegistrationPage

def test_fifth_task(driver):
    time.sleep(3)
    MainPage(driver).click_search("random text!")