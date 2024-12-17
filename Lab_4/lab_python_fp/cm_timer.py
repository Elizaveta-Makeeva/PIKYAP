from time import time, sleep
from contextlib import contextmanager


class cm_timer_1:
    def __enter__(self):
        self.start_time = time()
        return self

    def __exit__(self, exception_type, exception_value, traceback):
        self.end_time = time()
        elapsed_time = self.end_time - self.start_time
        print(f'time: {elapsed_time:.2f}')


@contextmanager
def cm_timer_2():
    start_time = time()
    try:
        yield
    finally:
        end_time = time()
        elapsed_time = end_time - start_time
        print(f'time: {elapsed_time:.2f}')


if __name__ == '__main__':
    print("Using cm_timer_1:")
    with cm_timer_1():
        sleep(5.5)

    print("Using cm_timer_2:")
    with cm_timer_2():
        sleep(5.5)
