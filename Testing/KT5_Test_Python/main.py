import httpx
import pytest
from pydantic import BaseModel, HttpUrl

BASE_URL = "https://dog.ceo/api"

async def get_response(url):
    async with httpx.AsyncClient() as client:
        response = await client.get(url)
        response.status_code == 2
        return response.json()['message']

@pytest.mark.asyncio
async def test_breeds_list():
    url = f"{BASE_URL}/breeds/list/all"
    breeds_data = await get_response(url)
    assert isinstance(breeds_data, dict)
    assert len(breeds_data) > 0

@pytest.mark.asyncio
async def test_random_image():
    url = f"{BASE_URL}/breeds/image/random"
    image_url = await get_response(url)
    assert image_url.endswith('.png') or image_url.endswith('.jpg')

@pytest.mark.asyncio
async def test_sub_breeds_list():
    url = f"{BASE_URL}/breed/hound/list"
    sub_breeds_data = await get_response(url)
    assert isinstance(sub_breeds_data, list)
    assert len(sub_breeds_data) > 0

@pytest.mark.asyncio
@pytest.mark.parametrize("breed_name", ["hound", "beagle", "bulldog"])
async def test_sub_breed_images(breed_name):
    url = f"{BASE_URL}/breed/{breed_name}/images"
    sub_breed_images = await get_response(url)
    assert isinstance(sub_breed_images, list)
    assert len(sub_breed_images) > 0

@pytest.mark.asyncio
async def test_random_sub_breed_image():
    url = f"{BASE_URL}/breed/hound/afghan/images/random"
    image_url = await get_response(url)
    assert image_url.endswith('.png') or image_url.endswith('.jpg')
