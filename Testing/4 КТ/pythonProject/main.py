import requests
import pprint
import json

BASE_URL_PETSTORE = 'https://petstore.swagger.io/v2'

# GET
user_id = 1
response = requests.get(f'{BASE_URL_PETSTORE}/user/{user_id}')
pprint.pprint('GET example')

pprint.pprint(response.url)
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)
pprint.pprint(response.json())
pprint.pprint('**********')

# POST
data = {'name': 'Leonard'}
response = requests.post(f'{BASE_URL_PETSTORE}/user', json=data)

pprint.pprint('POST example')
pprint.pprint(response.status_code)
pprint.pprint(response.reason)

dict_text = json.loads(response.text)
user_id = dict_text['message']

pprint.pprint('**********')

# DELETE
response = requests.delete(f'{BASE_URL_PETSTORE}/user/{user_id}')

pprint.pprint('DELETE example')
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)

response = requests.get(f'{BASE_URL_PETSTORE}/user/{user_id}')
pprint.pprint(f'GET {user_id}')

pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)
pprint.pprint('**********')

# PUT
updated_user_data = {
    'id': 1,
    'username': 'newuser_updated',
    'firstName': 'UpdatedFirstName',
    'lastName': 'UpdatedLastName',
    'email': 'updated@example.com',
    'phone': '9876543210'
}

response = requests.put(f'{BASE_URL_PETSTORE}/user/1', json=updated_user_data)
pprint.pprint('PUT example')
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)




# GET
order_id = 2
response = requests.get(f'{BASE_URL_PETSTORE}/store/order/{order_id}')
pprint.pprint('GET example')

pprint.pprint(response.url)
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)
pprint.pprint(response.json())
pprint.pprint('**********')

# POST
data = {'status': 'placed'}
response = requests.post(f'{BASE_URL_PETSTORE}/store/order/{order_id}', json=data)

pprint.pprint('POST example')
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint('**********')

# DELETE
response = requests.delete(f'{BASE_URL_PETSTORE}/store/order/{order_id}')

pprint.pprint('DELETE example')
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)

response = requests.get(f'{BASE_URL_PETSTORE}/store/order/{order_id}')
pprint.pprint(f'GET {order_id}')

pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)
pprint.pprint('**********')

# PUT
updated_order_data = {
    "id": 2,
    "petId": 9,
    "quantity": 0,
    "shipDate": "2025-03-05T11:45:38.885+0000",
    "status": "placed"
}

response = requests.put(f'{BASE_URL_PETSTORE}/store/order/{order_id}', json=updated_order_data)
pprint.pprint('PUT example')
pprint.pprint(response.status_code)
pprint.pprint(response.reason)
pprint.pprint(response.text)
