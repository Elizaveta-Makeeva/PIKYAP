def field(items, *args):
    assert len(args) > 0

    if len(args) == 1:
        for i in items:
            if i[args[0]] is not None:
                yield i[args[0]]
    else:
        for i in items:
            d = {}
            for j in args:
                if j in i:
                    d[j] = i[j]
            yield d

goods = [{'title': 'Ковер', 'price': 2000, 'color': 'green'},
    {'title': 'Диван для отдыха', 'color': 'black'}]

print(list(field(goods, 'title')))
print(list(field(goods, 'title', 'price')))