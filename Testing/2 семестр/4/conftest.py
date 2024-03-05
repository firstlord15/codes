import datetime
import os
import pytest
import logging

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.firefox.options import Options as FirefoxOptions

def pytest_addoption(parser):
    parser.addoption("--browser", default="chrome")
    parser.addoption("--drivers", default=os.path.expanduser("C:\\webdrivers"))
    parser.addoption("--log_level", action="store", default="INFO")
    parser.addoption("--headless", action="store_true")

@pytest.fixture
def driver(request):
    browser = request.config.getoption("--browser")
    drivers = request.config.getoption("--drivers")
    log_level = request.config.getoption("--log_level")
    headless = request.config.getoption("--headless")
    executor_url = "https://demo-opencart.ru"
    
    logger = logging.getLogger(request.node.name)
    file_handler = logging.FileHandler(f"logs/{request.node.name}.log")
    file_handler.setFormatter(logging.Formatter("%(levelname)s %(message)s"))
    logger.addHandler(file_handler)
    logger.setLevel(level=log_level)

    logger.info(
        "===> Test %s started at %s" % (request.node.name, datetime.datetime.now())
    )

    if browser == "chrome": 
        options = Options()
        if headless:
            options.add_argument("headless")
        driver = webdriver.Remote(
            command_executor=executor_url,
            options=options
        )
    elif browser == "yandex":
        options = webdriver.ChromeOptions()
        binary_yandex_driver_file = os.path.join(drivers, 'yandexdriver\\yandexdriver.exe')
        service = webdriver.chrome.service.Service(executable_path=binary_yandex_driver_file)
        driver = webdriver.Chrome(service=service, options=options)
    elif browser == "firefox":
        options = FirefoxOptions()
        if headless:
            options.headless = True
        driver = webdriver.Firefox(options=options)
    else:
        raise NotImplemented()
    
    driver.log_level = log_level
    driver.logger = logger
    driver.test_name = request.node.name
    
    logger.info("Browser %s started" % browser)

    def fin():
        driver.get(executor_url)
        driver.quit()
        logger.info(
            "===> Test %s finished at %s" % (request.node.name, datetime.datetime.now())
        )

    request.addfinalizer(fin())

    return driver