import requests
from faker import Faker
from pydantic import BaseModel
fake = Faker()

class DefaultQuestion(BaseModel):
    id: int
    question: str
    answer: str

jsonschema = {
    "id": "1", "question": f"SSS",
    "possibleAnswers": {
        "0": "no correct",
        "1": "no correct x2",
        "3": "no correct x3",
        "4": "This is the answer."
    },
    "correctAnswer": "This is the answer."
}



def test_get():
    # Отправляем запрос на создание вопроса
    response = requests.get("https://api.sampleapis.com/futurama/questions")

    # Проверяем статус код
    assert response.status_code == 200


def test_create_question():
    # Отправляем запрос на создание вопроса
    response = requests.post("https://api.sampleapis.com/futurama/questions", json=jsonschema)

    # Проверяем статус код
    assert response.status_code == 200

    # Проверяем JSON схему с использованием Pydantic модели
    created_question = DefaultQuestion(**response.json())


def test_get_question():
    # Отправляем запрос на получение вопроса
    response = requests.get("https://api.sampleapis.com/futurama/questions/1")

    # Проверяем статус код
    assert response.status_code == 200

    # Проверяем JSON схему с использованием Pydantic модели
    question = DefaultQuestion(**response.json())


def test_update_question():
    # Отправляем запрос на обновление вопроса
    response = requests.put("https://api.sampleapis.com/futurama/questions/1", json=jsonschema)

    # Проверяем статус код
    assert response.status_code == 200

    # Проверяем JSON схему с использованием Pydantic модели
    updated_question = DefaultQuestion(**response.json())


def test_delete_question():
    # Отправляем запрос на удаление вопроса
    response = requests.delete("https://api.sampleapis.com/futurama/questions/1")

    # Проверяем статус код
    assert response.status_code == 200
