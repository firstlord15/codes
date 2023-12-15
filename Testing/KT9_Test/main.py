import pytest
import httpx

# URL для API веб-приложения
API_URL = "http://localhost:8000/api"

# Тест, который проверяет, что пользователь может успешно зарегистрироваться
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
    # Отправляем POST-запрос к API для входа
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "/login", json=data)
    # Проверяем, что статус ответа 200 (OK)
    assert response.status_code == 200
    # Проверяем, что тело ответа содержит токен доступа
    assert "access_token" in response.json()

# Тест, который проверяет, что пользователь может успешно просмотреть свой профиль
@pytest.mark.asyncio
async def test_get_profile(event_loop):
    # Данные для входа
    data = {
        "username": "testuser",
        "password": "testpass"
    }
    # Отправляем POST-запрос к API для входа и получаем токен доступа
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "/login", json=data)
        token = response.json()["access_token"]
    # Отправляем GET-запрос к API для просмотра профиля с токеном в заголовке Authorization
    async with httpx.AsyncClient() as client:
        response = await client.get(API_URL + "/profile", headers={"Authorization": f"Bearer {token}"})
    # Проверяем, что статус ответа 200 (OK)
    assert response.status_code == 200
    # Проверяем, что тело ответа содержит данные профиля
    assert response.json() == {
        "username": "testuser",
        "email": "testuser@example.com",
        "name": "Test User"
    }

# Тест, который проверяет, что пользователь может успешно редактировать свой профиль
@pytest.mark.asyncio
async def test_update_profile(event_loop):
    # Данные для входа
    data = {
        "username": "testuser",
        "password": "testpass"
    }
    # Отправляем POST-запрос к API для входа и получаем токен доступа
    async with httpx.AsyncClient() as client:
        response = await client.post(API_URL + "/login", json=data)
        token = response.json()["access_token"]
    # Данные для редактирования профиля
    data = {
        "email": "testuser2@example.com",
        "name": "Test User 2"
    }
    # Отправляем PUT-запрос к API для редактирования профиля с токеном в заголовке Authorization
    async with httpx.AsyncClient() as client:
        response = await client.put(API_URL + "/profile", headers={"Authorization": f"Bearer {token}"}, json=data)
    # Проверяем, что статус ответа 200 (OK)
    assert response.status_code == 200
    # Проверяем, что тело ответа содержит обновленные данные профиля
    assert response.json() == {
        "username": "testuser",
        "email": "testuser2@example.com",
        "name": "Test User 2"
    }
