
// Задание 1

let first_phones = [
    '590.423.4568',
    '650.124.7234',
    '650.507.9879',
    '011.44.1343.529268',
    '011.44.1344.478968',
    '011.44.1644.429267',
    '11.44.1343.52',
    '11.44.1643.52'
]

let masking_phone = first_phones.map(phone => {
    let list_parts = phone.split('.')
    list_parts[list_parts.length - 1] = list_parts[list_parts.length - 1].replace(/\d/g, '*')
    return list_parts.join('.')
});

console.log(masking_phone);

// Задание 2

let second_phones = [
    '4000 0012 0056 9499',
    '4000 0013 5456 7379',
    '4000 0014 1456 9869',
    '4000 0015 3466 7859',
    '4000 0016 3556 6899',
    '4000 0017 4456 4699'
]

let masking_cards = second_phones.map(card => {
    let fix_space = card.replace(/\D/g, '')
    let first_part = fix_space.slice(0, 4)
    let last_part = fix_space.slice(-4)
    return first_part + '*'.repeat(5) + last_part
});

console.log(masking_cards)

// Задание 3


let prices = [
    'Цена товара - 1200$',
    'Стоимость - 500$',
    'Цена не определена', '9999',
    'Ценовая категория - больше 300$',
    'Цена за услугу 500 EUR',
    '150$',
]

function getInfo(arr) {
    let text_count = 0
    let dollars_count = 0

    for (let i = 0; i < arr.length; i++){
        if (arr[i].startsWith('Цена')){
            text_count++
        }
        if (arr[i].endsWith('$')){
            dollars_count++
        }
    }
    return [text_count, dollars_count]
}


console.log(getInfo(prices))


// Задание 4
function kingSayd(str) {
    if (str.startsWith("Король сказал") === false){
        console.log("Король сказал: " + str)
    }
    else
    {
        console.log(str)
    }
}

kingSayd("asd хорошая погода");

// Задание 5

function isItFridayToday() {
    let today = new Date();
    let day = today.getDay();

    if (day === 5) {
        return 'Сегодня пятница!';
    } else if (day === 4) {
        return 'Пятница была вчера.';
    } else if (day === 6) {
        return 'Завтра пятница!';
    } else {
        let daysUntilFriday = (5 + 7 - day) % 7;
        return 'Пятница будет через ' + daysUntilFriday + ' дней.';
    }
}

console.log(isItFridayToday());