from behave import given, when, then
from field_module import field


@given('a list of goods')
def step_given_list_of_goods(context):
    context.goods = [
        {'title': 'Ковер', 'price': 2000, 'color': 'green'},
        {'title': 'Диван для отдыха', 'color': 'black'}
    ]


@when('I get the "{field_name}" field')
def step_when_get_single_field(context, field_name):
    context.result = list(field(context.goods, field_name))


@when('I get the "{field1}" and "{field2}" fields')
def step_when_get_multiple_fields(context, field1, field2):
    context.result = list(field(context.goods, field1, field2))


@when('I try to get an empty field list')
def step_when_try_empty_field_list(context):
    try:
        context.result = list(field(context.goods))
    except AssertionError as e:
        context.result = str(e)


@then('I should get the result {expected_result}')
def step_then_check_result(context, expected_result):
    expected_result = eval(expected_result)
    assert context.result == expected_result


@then('I should receive an error "{error_message}"')
def step_then_check_error(context, error_message):
    assert context.result == error_message
