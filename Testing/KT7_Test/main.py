from database import add_record_to_database
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
            return await response.json()


@pytest.mark.asyncio
async def test_async_http_request(event_loop):
    result = await async_http_request()
    assert "id" in result
    assert "username" in result
    assert "firstName" in result
    assert "lastName" in result
    assert "email" in result
    assert "password" in result
    assert "phone" in result
    assert "userStatus" in result



@pytest.mark.asyncio
async def test_add_record_to_database(event_loop):
    data_to_insert = ("value1", "value2")
    result = await add_record_to_database(data_to_insert)

    assert result is not None




