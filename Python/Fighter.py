import random as rn

# def custom_randint(low, high):
#     probabilities = list(range(80, 8, -1))
#     num = rn.choices(range(low, high+1), weights=probabilities/100)[0]
#     return num

# print(custom_randint(80, 8))

class Fighter:

    # Name --> string
    # Power --> int(1, 100) все включительно
    # Agility --> int(1, 100) все включительно
    # Protection --> int(1, 100) все включительно
    # Skills ---> int(1, 10) все включительно

    def __init__(self, name, power, agility, protection, skills, is_alive = True, HP = 100):
        self.name = name
        self.power = power
        self.agility = agility
        self.protection = protection
        self.skills = skills
        self.is_alive = is_alive
        self.HP = HP

    def attack(self, protect):   
        # if rn.choice([True, False]):
        #     fighter.HP -= rn.randint(13, 19)
        #     print(f'Fighter hp = {fighter.HP}')
        # else:
        #     print('You miss!')

        # Урон от атаки = (Сила Атакующего + Ловкость Атакующего) - (Защита Защищающегося + Ловкость Защищающегося) + (Навыки Атакующего - Навыки Защищающегося)

        result = 0
        if (self.skills - protect.skills) <= 3 and (self.skills - protect.skills) > 0:
            result += ((((self.power + self.agility)/4) * (self.skills/35)))  - ((protect.protection + protect.agility) * (self.skills/45))
        elif (self.skills - protect.skills) > 3 and (self.skills - protect.skills) < 6:
            result += ((((self.power + self.agility)/4) * ((self.skills)/15))) * ((protect.protection + protect.agility) * (self.skills/25))
        elif (self.skills - protect.skills) >= 6:
            result += ((((self.power + self.agility)/4) * ((self.skills)/5))) * ((protect.protection + protect.agility) * (self.skills/15))
        elif (self.skills - protect.skills) == 0:
            result += ((((self.power + self.agility)/4) * ((self.skills)))) * ((protect.protection + protect.agility) * (self.skills))
        elif (self.skills - protect.skills) < 0:
            result += ((((self.power + self.agility)/4) * (self.skills/15))) * ((protect.protection + protect.agility) * (self.skills/30))
        
        result = round(result)
        
        print(f'self = {self.name}\nprotect = {protect.name}')
        print(f'attack = {result}')
        print(f'skills = {(self.skills - protect.skills)}')



        return
    

    def show_info(self):
        pass



first_player = Fighter('Ratmir', 100, 100, 100, 6)
second_player = Fighter('Ogi', 100, 100, 100, 5)
first_player.attack(second_player)