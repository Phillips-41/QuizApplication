INSERT INTO topic (topic_id, name)
SELECT 1, 'Java'
WHERE NOT EXISTS (SELECT 1 FROM topic WHERE name = 'Java');

-- Insert Question 1
INSERT INTO question (id, title, topic_id)
SELECT 1, 'What is the default value of a boolean variable in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'What is the default value of a boolean variable in Java?');

-- Insert Question 2
INSERT INTO question (id, title, topic_id)
SELECT 2, 'Which keyword is used to define a class in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which keyword is used to define a class in Java?');

-- Insert Question 3
INSERT INTO question (id, title, topic_id)
SELECT 3, 'What is the size of an int variable in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'What is the size of an int variable in Java?');

-- Insert Question 4
INSERT INTO question (id, title, topic_id)
SELECT 4, 'Which method is used to start a thread in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which method is used to start a thread in Java?');

-- Insert Question 5
INSERT INTO question (id, title, topic_id)
SELECT 5, 'Which of the following is not a keyword in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which of the following is not a keyword in Java?');

-- Insert Question 6
INSERT INTO question (id, title, topic_id)
SELECT 6, 'Which of the following is a wrapper class in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which of the following is a wrapper class in Java?');

-- Insert Question 7
INSERT INTO question (id, title, topic_id)
SELECT 7, 'Which of these access specifiers is used to inherit members from a class in another package?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which of these access specifiers is used to inherit members from a class in another package?');

-- Insert Question 8
INSERT INTO question (id, title, topic_id)
SELECT 8, 'Which exception is thrown when a division by zero occurs?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which exception is thrown when a division by zero occurs?');

-- Insert Question 9
INSERT INTO question (id, title, topic_id)
SELECT 9, 'Which operator is used to compare two objects in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'Which operator is used to compare two objects in Java?');

-- Insert Question 10
INSERT INTO question (id, title, topic_id)
SELECT 10, 'What is the base class for all exceptions in Java?', 1
WHERE NOT EXISTS (SELECT 1 FROM question WHERE title = 'What is the base class for all exceptions in Java?');

-- Options for Question 1
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 1, 'true', false, 1
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'true' AND question_id = 1);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 2, 'false', true, 1
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'false' AND question_id = 1);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 3, 'null', false, 1
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'null' AND question_id = 1);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 4, 'undefined', false, 1
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'undefined' AND question_id = 1);

-- Options for Question 2
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 5, 'class', true, 2
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'class' AND question_id = 2);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 6, 'new', false, 2
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'new' AND question_id = 2);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 7, 'public', false, 2
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'public' AND question_id = 2);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 8, 'void', false, 2
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'void' AND question_id = 2);

-- Options for Question 3
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 9, '16 bits', false, 3
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = '16 bits' AND question_id = 3);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 10, '32 bits', true, 3
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = '32 bits' AND question_id = 3);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 11, '64 bits', false, 3
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = '64 bits' AND question_id = 3);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 12, '128 bits', false, 3
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = '128 bits' AND question_id = 3);

-- Options for Question 4: Which method is used to start a thread in Java?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 13, 'run()', false, 4
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'run()' AND question_id = 4);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 14, 'start()', true, 4
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'start()' AND question_id = 4);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 15, 'execute()', false, 4
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'execute()' AND question_id = 4);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 16, 'begin()', false, 4
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'begin()' AND question_id = 4);

-- Options for Question 5: Which of the following is not a keyword in Java?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 17, 'goto', false, 5
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'goto' AND question_id = 5);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 18, 'null', false, 5
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'null' AND question_id = 5);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 19, 'String', true, 5
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'String' AND question_id = 5);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 20, 'volatile', false, 5
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'volatile' AND question_id = 5);

-- Options for Question 6: Which of the following is a wrapper class in Java?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 21, 'int', false, 6
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'int' AND question_id = 6);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 22, 'Integer', true, 6
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'Integer' AND question_id = 6);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 23, 'char', false, 6
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'char' AND question_id = 6);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 24, 'boolean', false, 6
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'boolean' AND question_id = 6);

-- Options for Question 7: Which of these access specifiers is used to inherit members from a class in another package?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 25, 'private', false, 7
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'private' AND question_id = 7);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 26, 'protected', true, 7
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'protected' AND question_id = 7);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 27, 'default', false, 7
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'default' AND question_id = 7);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 28, 'public', false, 7
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'public' AND question_id = 7);

-- Options for Question 8: Which exception is thrown when a division by zero occurs?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 29, 'NullPointerException', false, 8
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'NullPointerException' AND question_id = 8);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 30, 'ArithmeticException', true, 8
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'ArithmeticException' AND question_id = 8);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 31, 'IOException', false, 8
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'IOException' AND question_id = 8);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 32, 'ClassCastException', false, 8
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'ClassCastException' AND question_id = 8);

-- Options for Question 9: Which operator is used to compare two objects in Java?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 33, '==', false, 9
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = '==' AND question_id = 9);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 34, 'equals()', true, 9
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'equals()' AND question_id = 9);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 35, '!=', false, 9
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = '!=' AND question_id = 9);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 36, 'compare()', false, 9
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'compare()' AND question_id = 9);

-- Options for Question 10: What is the base class for all exceptions in Java?
INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 37, 'Throwable', true, 10
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'Throwable' AND question_id = 10);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 38, 'Exception', false, 10
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'Exception' AND question_id = 10);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 39, 'RuntimeException', false, 10
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'RuntimeException' AND question_id = 10);

INSERT INTO options (id, option_text, is_correct, question_id)
SELECT 40, 'Error', false, 10
WHERE NOT EXISTS (SELECT 1 FROM options WHERE option_text = 'Error' AND question_id = 10);

