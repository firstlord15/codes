import os
import pytest
from config import website
from selenium import webdriver

def pytest_addoption(parser):
    parser.addoption("--browser", default="yandex")
    parser.addoption("--drivers", default=os.path.expanduser("C:\\webdrivers"))

@pytest.fixture
def driver(request):
    browser = request.config.getoption("--browser")
    drivers = request.config.getoption("--drivers")

    if browser == "chrome":
        driver = webdriver.Chrome()
    elif browser == "yandex":
        options = webdriver.ChromeOptions()
        binary_yandex_driver_file =  os.path.join(drivers, 'yandexdriver\\yandexdriver.exe')
        service = webdriver.chrome.service.Service(executable_path=binary_yandex_driver_file)
        driver = webdriver.Chrome(service=service, options=options)
    elif browser == "firefox":
        driver = webdriver.Firefox()
    else:
        raise Exception("Driver not supported")

    driver.get(website)
    request.addfinalizer(driver.quit)

    return driver