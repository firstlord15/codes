from toolz import curry
import re

txt = 'Hello, world!: I see that, all work in my code'

slpit = curry(re.split) # re -> str
search = curry(re.search) # re -> str
join = curry(str.join) # str -> []

filter = curry(filter) # fn -> []
map = curry(map) # fn -> []

upper = str.upper
lower = str.lower


