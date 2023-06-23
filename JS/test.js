// 1

let phones = [
    '590.423.4568',
    '650.124.7234',
    '650.507.9879',
    '011.44.1343.529268',
    '011.44.1344.478968',
    '011.44.1644.429267',
    '11.44.1343.52',
    '11.44.1643.52'
];

let maskedPhones = phones.map(phone => {
    let parts = phone.split('.');
    let lastPart = parts.pop();
    let maskedPart = lastPart.replace(/\d/g, '*');
    return parts.join('.') + '.' + maskedPart;
});

console.log(maskedPhones);


// 2
let cards = [
    '4000 0012 0056 9499',
    '4000 0013 5456 7379',
    '4000 0014 1456 9869',
    '4000 0015 3466 7859',
    '4000 0016 3556 6899',
    '4000 0017 4456 4699'
];

let maskedCards = cards.map(card => {
    let digitsOnly = card.replace(/\D/g, '');
    let firstFour = digitsOnly.slice(0, 4);
    let lastFour = digitsOnly.slice(-4);
    let maskedPart = '*'.repeat(digitsOnly.length - 8);
    return firstFour + maskedPart + lastFour;
});

console.log(maskedCards);


// 3
function getInfo(prices) {
    let startsWithCount = 0;
    let endsWithCount = 0;

    for (let i = 0; i < prices.length; i++) {
        if (prices[i].startsWith('Цена')) {
            startsWithCount++;
        }
        if (prices[i].endsWith('$')) {
            endsWithCount++;
        }
    }

    return [startsWithCount, endsWithCount];
}

let prices = [
    'Цена товара - 1200$',
    'Стоимость - 500$',
    'Цена не определена', '9999',
    'Ценовая категория - больше 300$',
    'Цена за услугу 500 EUR',
    '150$',
];

console.log(getInfo(prices));


// 4
function kingSaid(string) {
    if (string.startsWith("Король сказал:")) {
        console.log(string);
    } else {
        console.log("Король сказал: " + string);
    }
}

kingSaid("сегодня хорошая погода");

// 5
function isItFridayToday() {
    var today = new Date();
    var friday = new Date(today);

    // Поиск ближайшей пятницы
    friday.setDate(today.getDate() + ((12 - today.getDay() + 1) % 7));

    if (today.getDay() === 5) {
        console.log("Сегодня пятница!");
    } else if (friday.getDate() === today.getDate()) {
        console.log("Пятница была вчера");
    } else if (friday.getDate() === today.getDate() + 2) {
        console.log("Завтра пятница!");
    } else {
        var daysUntilFriday = Math.ceil((friday.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
        console.log("Пятница будет через " + daysUntilFriday + " " + getDaysWord(daysUntilFriday));
    }
}

function getDaysWord(days) {
    if (days === 1) {
        return "день";
    } else if (days >= 2 && days <= 4) {
        return "дня";
    } else {
        return "дней";
    }
}

isItFridayToday();
