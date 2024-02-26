import os
import pytest
from selenium import webdriver
import logging

website = "https://demo-opencart.ru"

def pytest_addoption(parser):
    parser.addoption("--browser", default="chrome")
    parser.addoption("--drivers", default=os.path.expanduser("C:\\webdrivers"))
    parser.addoption("--log_level", action="store", default="INFO")

@pytest.fixture
def driver(request):
    browser = request.config.getoption("--browser")
    drivers = request.config.getoption("--drivers")
    log_level = request.config.getoption("--log_level")
    logger = logging.getLogger(request.node.name)

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