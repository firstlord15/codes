import requests
import pprint


class BaseRequest:
    def __init__(self, base_url):
        self.base_url = base_url

    def _request(self, url, request_type, data=None, expected_error=False):
        stop_flag = False
        while not stop_flag:
            if request_type == 'GET':
                response = requests.get(url)
            elif request_type == 'POST':
                response = requests.post(url, json=data)
            elif request_type == 'DELETE':
                response = requests.delete(url)
            else:
                raise ValueError("Unsupported request_type")

            if not expected_error and response.status_code == 200:
                stop_flag = True
            elif expected_error:
                stop_flag = True

        # log part
        pprint.pprint(f'{request_type} example')
        pprint.pprint(response.url)
        pprint.pprint(response.status_code)
        pprint.pprint(response.reason)
        pprint.pprint(response.text)
        pprint.pprint(response.json())
        pprint.pprint('**********')
        return response

    def get(self, endpoint, endpoint_id, expected_error=False):
        url = f'{self.base_url}/{endpoint}/{endpoint_id}'
        response = self._request(url, 'GET', expected_error=expected_error)
        return response.json()

    def post(self, endpoint, body):
        url = f'{self.base_url}/{endpoint}'
        response = self._request(url, 'POST', data=body)
        return response.json()

    def delete(self, endpoint, endpoint_id):
        url = f'{self.base_url}/{endpoint}/{endpoint_id}'
        response = self._request(url, 'DELETE')
        return response.json()


BASE_URL_PETSTORE = 'https://petstore.swagger.io/v2'
base_request = BaseRequest(BASE_URL_PETSTORE)

# GET User
user_info = base_request.get('user', 1)
pprint.pprint(user_info)

# POST User
data = {'name': 'Leonard',
        'email': 'leonard123@gmail.com',
        'phone': '+123456789'}
created_user = base_request.post('user', data)
pprint.pprint(created_user)

# DELETE User
request_id = created_user['id']
deleted_user = base_request.delete('user', request_id)
pprint.pprint(deleted_user)

# PUT User
updated_user_data = {
    'id': 1,
    'username': 'newuser_updated',
    'firstName': 'UpdatedFirstName',
    'lastName': 'UpdatedLastName',
    'email': 'updated@example.com',
    'phone': '9876543210'
}

updated_user = base_request.put('user', 1, updated_user_data)
pprint.pprint(updated_user)




# GET Store
store_info = base_request.get('store', 1)
pprint.pprint(store_info)

# POST Store
data = {'name': 'Leonard',
        'email': 'leonard123@gmail.com',
        'phone': '+123456789'}
created_order = base_request.post('order', data)
pprint.pprint(created_order)

# DELETE Store
request_id = created_order['id']
deleted_order = base_request.delete('order', request_id)
pprint.pprint(deleted_order)

# PUT Store
updated_order_data = {
    "id": 2,
    "petId": 9,
    "quantity": 0,
    "shipDate": "2025-03-05T11:45:38.885+0000",
    "status": "placed"
}

updated_user = base_request.put('order', 1, updated_order_data)
pprint.pprint(updated_user)






