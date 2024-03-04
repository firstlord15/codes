import datetime
import os
import pytest
import logging

from selenium import webdriver

def pytest_addoption(parser):
    parser.addoption("--browser", default="chrome")
    parser.addoption("--drivers", default=os.path.expanduser("C:\\webdrivers"))
    parser.addoption("--log_level", action="store", default="INFO")

@pytest.fixture
def driver(request):
    browser = request.config.getoption("--browser")
    drivers = request.config.getoption("--drivers")
    log_level = request.config.getoption("--log_level")
    executor_url = "https://demo-opencart.ru"
    
    logger = logging.getLogger(request.node.name)
    print(f"logs/{request.node.name}.log")
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
        binary_yandex_driver_file = os.path.join(drivers, 'yandexdriver\\yandexdriver.exe')
        service = webdriver.chrome.service.Service(executable_path=binary_yandex_driver_file)
        driver = webdriver.Chrome(service=service, options=options)
    elif browser == "firefox":
        driver = webdriver.Firefox()
    else:
        raise Exception("Driver not supported")
    
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