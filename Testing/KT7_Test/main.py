import aiohttp
import pytest


async def async_function_resolve():
    return "Expected Value"


@pytest.mark.asyncio
async def test_async_function_resolve(event_loop):
    result = await async_function_resolve()
    assert result == "Expected Value"


async def async_function_error():
    raise ValueError("An expected error occurred.")


@pytest.mark.asyncio
async def test_failed_promise_rejection(event_loop):
    with pytest.raises(ValueError, match="An expected error occurred."):
        await async_function_error()


async def async_http_request():
    async with aiohttp.ClientSession() as session:
        async with session.get("https://petstore.swagger.io/v2/user/string") as response:
            return response._body

jsonExmple = {
    "id": 9223372036854771000,
    "username": "string",
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string",
    "phone": "string",
    "userStatus": 0
}


@pytest.mark.asyncio
async def test_async_http_request(event_loop):
    result = await async_http_request()
    assert result == jsonExmple
