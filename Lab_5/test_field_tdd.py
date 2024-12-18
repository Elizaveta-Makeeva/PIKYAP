import unittest
from field_module import field


class TestField(unittest.TestCase):

    def test_single_field(self):
        items = [{'title': 'Ковер', 'price': 2000, 'color': 'green'},
            {'title': 'Диван для отдыха', 'color': 'black'}]
        result = list(field(items, 'title'))
        self.assertEqual(result, ['Ковер', 'Диван для отдыха'])

    def test_multiple_fields(self):
        items = [{'title': 'Ковер', 'price': 2000, 'color': 'green'},
            {'title': 'Диван для отдыха', 'color': 'black'}]
        result = list(field(items, 'title', 'price'))
        self.assertEqual(result, [{'title': 'Ковер', 'price': 2000}, {'title': 'Диван для отдыха'}])

    def test_empty_input(self):
        items = []
        result = list(field(items, 'title'))
        self.assertEqual(result, [])


if __name__ == '__main__':
    unittest.main()
