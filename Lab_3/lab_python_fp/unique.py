class Unique(object):
    def __init__(self, items, **kwargs):
        self.ignore_case = kwargs.get('ignore_case', False)
        self.items = list(items)
        self.received = set()
        self.index = 0

    def __next__(self):
        while self.index < len(self.items):
            item = self.items[self.index]
            self.index += 1

            if self.ignore_case and isinstance(item, str):
                item_key = item.lower()
            else:
                item_key = item

            if item_key not in self.received:
                self.received.add(item_key)
                return item
        raise StopIteration

    def __iter__(self):
        return self

data1 = [1, 1, 1, 1, 1, 2, 2, 2, 2, 2]
unique1 = Unique(data1)
print(list(unique1))
data2 = ['a', 'A', 'b', 'B', 'a', 'A', 'b', 'B']
unique2 = Unique(data2)
print(list(unique2))
unique3 = Unique(data2, ignore_case=True)
print(list(unique3))
