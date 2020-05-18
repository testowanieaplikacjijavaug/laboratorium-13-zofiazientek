Narrative:
In order to test fizz buzz class
As a user
I want to check number's divisibility

Scenario:  Fizz buzz test with number divisible by 15
Given Fizz buzz class
When number = 45
Then result I get: FizzBuzz

Scenario:  Fizz buzz test with non-zero number indivisible by 3 or by 5
Given Fizz buzz class
When number = 4
Then result I get: number value

Scenario:  Fizz buzz test with zero
Given Fizz buzz class
When number = 0
Then error message

Scenario:  Fizz buzz test with number divisible by 15 with examples
Given Fizz buzz class
When number = <number>
Then result I get: <result>

Examples:
|number|result|
|15|"FizzBuzz"|
|30|"FizzBuzz"|
|60|"FizzBuzz"|

Scenario:  Fizz buzz test with non-zero number indivisible by 3 or by 5 with examples
Given Fizz buzz class
When number = <number>
Then result I get: number <value>

Examples:
|number|value|
|4|4|
|8|8|
|11|11|
