import random
from colorama import Fore, init

init()

print('\n\n')
print('--------------------------------------------------------')


class Fighter:
    def __init__(self, name: str, height: float = None, weight: float = None):
        self.name = name

        if height is None and weight is None:
            height = random.randint(150, 200) / 100
            weight = random.randint(50, 100)

        elif height is None and weight is not None:
            height = random.randint(150, 200) / 100

        elif height is not None and weight is None:
            weight = random.randint(50, 100)

        self.weight = weight
        self.height = height

        st = int(self.weight / self.height ** 2)
        self.power = st

        self.is_alive = True
        self.hp = 100

        print(
            f'   {Fore.CYAN}{self.name}:   Рост: {Fore.YELLOW}{self.height}{Fore.CYAN}, Вес: {Fore.YELLOW}{self.weight}{Fore.CYAN}, Сила: {Fore.YELLOW}{self.power}',
            Fore.WHITE)

    def attack(self, opponent):
        if not opponent.is_alive:
            return False

        elif random.random() < self.power / (self.power + opponent.power):
            # Атака успешна
            damage = int((random.randint(10, 30) + self.power / 2) - (opponent.power / 3))
            opponent.receive_damage(damage)
            return True

        else:
            # Атака неудачна
            print(f"   {Fore.GREEN}{opponent.name}:   блокировал атаку{Fore.WHITE}")
            return False

    def receive_damage(self, damage: int):
        self.hp -= damage

        print(f"   {Fore.YELLOW}{self.name}:   Отхватил: {damage}, Здоровья: {self.hp}{Fore.WHITE}")

        if self.hp <= 0:
            self.is_alive = False
            print('--------------------------------------------------------')
            print(f"   {Fore.RED}{self.name} погиб{Fore.WHITE}")

    def show_info(self):
        print(f"   {Fore.YELLOW}{self.name}, сила: {self.power}, {'жив' if self.is_alive else 'мертв'}{Fore.WHITE}")


class Contest:
    def __init__(self, fighter_first, fighter_second):
        self.fighter_first = fighter_first
        self.fighter_second = fighter_second

        if self.fighter_first.power > self.fighter_second.power:
            self.attacker = self.fighter_first
            self.defender = self.fighter_second
        else:
            self.attacker = self.fighter_second
            self.defender = self.fighter_first

    def fight(self):

        print('--------------------------------------------------------')
        print(f'   {Fore.CYAN}{self.attacker.name} атакует первым', Fore.WHITE)
        print('--------------------------------------------------------')

        while self.attacker.is_alive and self.defender.is_alive:

            while self.attacker.attack(self.defender):
                if not self.defender.is_alive or not self.attacker.is_alive: break
                if not self.attacker.attack(self.defender): break

            if not self.defender.is_alive or not self.attacker.is_alive: break

            self.attacker, self.defender = self.defender, self.attacker

        if self.attacker.is_alive:
            return self.attacker
        else:
            return self.defender


contest = Contest(Fighter("Вася"), Fighter("Петя"))
winner = contest.fight()
print(Fore.CYAN + "   Победил боец", winner.name + "!!!!!", Fore.WHITE)
print('\n\n')
