def print_result(func):
    def wrapper(*args, **kwargs):
        result = func(*args, **kwargs)
        print(func.__name__)

        if isinstance(result, list):
            for item in result:
                print(item)
        elif isinstance(result, dict):
            for key, value in result.items():
                print(f"{key} = {value}")
        else:
            print(result)

        return result

    return wrapper


@print_result
def f_1():
    return 1


@print_result
def f_2():
    return 'iu5'


@print_result
def f_3():
    return {'a': 1, 'b': 2}


@print_result
def f_4():
    return [1, 2]


if __name__ == '__main__':
    print('!!!!!!!!')
    f_1()
    f_2()
    f_3()
    f_4()