import pytest
import asyncio
from aiopg import pool
import aiohttp


async def async_function():
    return 42


@pytest.mark.asyncio
async def test_resolve_promise():
    result = await async_function()
    assert result == 42


async def async_function2():
    raise ValueError("Test error")


@pytest.mark.asyncio
async def test_reject_promise():
    with pytest.raises(ValueError, match="Test error"):
        await async_function2()


async def fetch_data():
    async with aiohttp.ClientSession() as session:
        async with session.get('https://api.example.com/data') as response:
            return await response.json()


@pytest.mark.asyncio
async def test_http_request():
    result = await fetch_data()
    assert 'key' in result


async def add_record_to_database():
    # Assume there's a database connection pool 'pool'
    async with pool.acquire() as connection:
        async with connection.cursor() as cursor:
            await cursor.execute("INSERT INTO records (data) VALUES ('test')")
            await connection.commit()


@pytest.mark.asyncio
async def test_database_interaction():
    await add_record_to_database()
    # Add assertions to check if the record was added successfully


async def async_function3():
    return 42


def run_async_function_in_thread():
    loop = asyncio.new_event_loop()
    asyncio.set_event_loop(loop)
    result = loop.run_until_complete(async_function())
    loop.close()
    return result


@pytest.mark.asyncio
async def test_run_in_thread():
    result = await asyncio.gather(run_async_function_in_thread())
    assert result[0] == 42
