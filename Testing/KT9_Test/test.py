import pytest
import httpx

API_URL = "http://localhost/"

@pytest.mark.asyncio
async def test_register(event_loop):
    data = {
        "username": "testuser",
        "password": "testpass",
        "email": "testuser@example.com",
        "name": "Test User"
    }
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "/register", json=data)
    assert response.status_code == 201
    assert "access_token" in response.json()

@pytest.mark.asyncio
async def test_login(event_loop):
    # Данные для входа
    data = {
        "username": "testuser",
        "password": "testpass"
    }
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "en-gb?route=account/login", json=data)
    assert response.status_code == 200
    assert "access_token" in response.json()

@pytest.mark.asyncio
async def test_get_profile(event_loop):
    data = {
        "username": "testuser",
        "password": "testpass"
    }
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "en-gb?route=account/login", json=data)
        token = response.json()["access_token"]
    async with httpx.AsyncClient() as client:
        response = await client.get(API_URL + "en-gb?route=account/profile", headers={"Authorization": f"Bearer {token}"})
    assert response.status_code == 200
    assert response.json() == {
        "username": "testuser",
        "email": "testuser@example.com",
        "name": "Test User"
    }

@pytest.mark.asyncio
async def test_update_profile(event_loop):
    data = {
        "username": "testuser",
        "password": "testpass"
    }
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "en-gb?route=account/login", json=data)
        token = response.json()["access_token"]
    data = {
        "email": "testuser2@example.com",
        "name": "Test User 2"
    }
    async with httpx.AsyncClient() as client:
        response = await client.put(API_URL + "en-gb?route=account/profile", headers={"Authorization": f"Bearer {token}"}, json=data)
    assert response.status_code == 200
    assert response.json() == {
        "username": "testuser",
        "email": "testuser2@example.com",
        "name": "Test User 2"
    }
