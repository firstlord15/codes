import os
import pytest

from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.firefox.service import Service as FirefoxService

from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager

def pytest_addoption(parser):
    parser.addoption("--browser", default="yandex")
    parser.addoption("--drivers", default=os.path.expanduser("C:\\webdrivers"))

@pytest.fixture
def driver(request):
    browser = request.config.getoption("--browser")
    drivers = request.config.getoption("--drivers")

    if browser == "chrome":
        driver = webdriver.Chrome(executable_path=ChromeDriverManager().install())
    elif browser == "yandex":
        yandex_driver_path = os.path.join(drivers, "yandexdriver\\yandexdriver.exe")
        options = webdriver.ChromeOptions()
        options.binary_location = yandex_driver_path
        driver = webdriver.Chrome(executable_path=yandex_driver_path, options=options)
    elif browser == "firefox":
        driver = webdriver.Firefox(executable_path=GeckoDriverManager().install())
    else:
        raise Exception("Driver not supported")

    request.addfinalizer(driver.quit)

    return driver