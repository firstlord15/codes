import requests

base_url = "https://api.sampleapis.com/futurama/characters"

response = requests.get(base_url)

# Проверяем успешность запроса
if response.status_code == 200:
    data = response.json()
    print(data)
else:
    print(f"Error: {response.status_code}")