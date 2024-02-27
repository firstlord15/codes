import datetime
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
    file_handler = logging.FileHandler(f"logs/{request.node.name}.log")
    file_handler.setFormatter(logging.Formatter("%(levelname)s %(message)s"))
    logger.addHandler(file_handler)
    logger.setLevel(level=log_level)

    logger.info(
        "===> Test %s started at %s" % (request.node.name, datetime.datetime.now())
    )

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

    browser.log_level = log_level
    browser.logger = logger
    
    logger.info("Browser %s started" % browser)

    def fin():
        driver.get(website)

        browser.quit()
        logger.info(
            "===> Test %s finished at %s" % (request.node.name, datetime.datetime.now())
        )

    request.addfinalizer(fin())

    return driver