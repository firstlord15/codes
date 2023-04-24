class User:
    count = 0
    
    def __init__(self, name, login, password, SuperUser_Status = False):
        self.__name = name
        self.__login = login
        self.__password = password
        self.SuperUser_Status = SuperUser_Status

        if SuperUser_Status == False:  User.count += 1

    @property
    def name(self): return self.__name

    @property
    def login(self): return self.__login

    @property
    def password(self): return '*'*len(self.__password)

    @name.setter
    def name(self, new_name): self.__name = new_name

    @password.setter
    def password(self, new_password): self.__password = new_password

    def show_info(self):
        print(f"Name: {self.__name}\nLogin: {self.__login}")

    
class SuperUser(User):
    count = 0
    def __init__(self, name, login, password, role, SuperUser_Status = True):
        self.__role = role
        super().__init__(name, login, password, SuperUser_Status)

        if SuperUser_Status: SuperUser.count += 1
    
    @property
    def role(self): return self.__role

    @role.setter
    def role(self, new_role): self.__role = new_role


user1 = User('Paul McCartney', 'paul', '1234')
user2 = User('George Harrison', 'george', '5678')
user3 = User('Richard Starkey', 'ringo', '8523')
admin = SuperUser('John Lennon', 'john', '0000', 'admin')

user1.show_info()
admin.show_info()

users = User.count
admins = SuperUser.count

print(f'Всего обычных пользователей: {users}')
print(f'Всего супер-пользователей: {admins}')
 
 

user3.name = 'Ringo Star'
user1.password = 'Pa$$w0rd'

print(user3.name)
print(user2.password)
print(user2.login)

user2.login = 'geo'