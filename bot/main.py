# import telebot
# import openai


# bot = telebot.TeleBot('6116110792:AAEI1yV2GpfCv1D1bh59F33J7MvwbGvoaWc')
# openai.api_key = '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'

# print('System: [Bot starting]')

# # @bot.message_handler(commands=['start'])
# # def start(message):
# #     mess = f'Привет, {message.from_user.first_name}, меня зовут Shone'
# #     bot.send_message(message.chat.id, mess)

# @bot.message_handler(content_types=['text'])
# def get_user_text(message):
    
    
#     bot.send_message(message.chat.id, response.choices[0].text)


# bot.polling(none_stop=True)


import openai
import json

# bot = telebot.TeleBot('6116110792:AAEI1yV2GpfCv1D1bh59F33J7MvwbGvoaWc')
openai.api_key = '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'

# Отправка запроса к API
def query(prompt):
    response = openai.Completion.create(
      engine="davinci",
      prompt=prompt,
      max_tokens=1024,
      n=1,
      stop=None,
      temperature=0.5,
    )
    message = response.choices[0].text.strip()
    return message

# Запуск бота

while True:
    prompt = input("Введите сообщение: ")
    if prompt == 'exit':
      break
    response = query(prompt)
    print(response)