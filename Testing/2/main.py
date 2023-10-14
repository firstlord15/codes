import csv
import json


def load_data(books, users):
    books = []
    users = []

    with open(books, newline='') as csvfile:
        spamreader = csv.DictReader(csvfile)
        for row in spamreader:
            books.append(row)

    with open(users) as jsonfile:
        f = json.load(jsonfile)
        for row in f:
            users.append(row)

    return users, books


def GetBookData(books):
    result = []
    if isinstance(books, list):

        for book in books:
            ObjetBook = {
                "title": book['Title'],
                "author": book['Author'],
                "pages": book['Pages'],
                "genre": book['Genre']
            }
            result.append(ObjetBook)
    else:
        ObjetBook = {
            "title": books['Title'],
            "author": books['Author'],
            "pages": books['Pages'],
            "genre": books['Genre']
        }

        result.append(ObjetBook)
    return result


def GetUserData(user, books):
    result_book = GetBookData(books)

    result = {
        "name": user['name'],
        "gender": user['gender'],
        "address": user['address'],
        "age": user['age'],
        "books": result_book
    },

    return result


def GetResultData(users: list, books: list):

    count_users = len(users)
    count_books = len(books)

    books_per_user = count_books // count_users
    remainder = count_books % count_users

    users_with_books = []
    for i in range(count_users):

        user = users[i]
        user_books = books[i * books_per_user:(i + 1) * books_per_user]

        if i < remainder:
            extra_book = books[count_users * books_per_user + i]
            user_books.append(extra_book)

        user_data = GetUserData(user, user_books)
        users_with_books.append(user_data)

    return users_with_books


if __name__ == "__main__":
    books = "books.csv"
    users = "users.json"
    users, books = load_data(books, users)
    result_data = GetResultData(users, books)
