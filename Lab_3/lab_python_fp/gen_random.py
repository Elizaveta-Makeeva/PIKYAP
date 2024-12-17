from random import randrange


def gen_random(num_count, begin, end):
    for i in range(num_count):
        yield randrange(begin, end + 1)

print(list(gen_random(5, 1, 3)))