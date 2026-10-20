USE music_library;
-- this is just sampl data to start the ca will update the dataset when we get more in depth and start working with other tables
INSERT INTO users (first_name, last_name, username, email, password_hash)
VALUES
    ('Ava', 'Murphy', 'ava.murphy', 'ava.murphy@example.com', 'REPLACE_WITH_BCRYPT_HASH_01'),
    ('Noah', 'Kelly', 'noah.kelly', 'noah.kelly@example.com', 'REPLACE_WITH_BCRYPT_HASH_02'),
    ('Sofia', 'Byrne', 'sofia.byrne', 'sofia.byrne@example.com', 'REPLACE_WITH_BCRYPT_HASH_03'),
    ('Jack', 'Walsh', 'jack.walsh', 'jack.walsh@example.com', 'REPLACE_WITH_BCRYPT_HASH_04'),
    ('Grace', 'Doyle', 'grace.doyle', 'grace.doyle@example.com', 'REPLACE_WITH_BCRYPT_HASH_05'),
    ('Liam', 'Ryan', 'liam.ryan', 'liam.ryan@example.com', 'REPLACE_WITH_BCRYPT_HASH_06'),
    ('Emily', 'Clarke', 'emily.clarke', 'emily.clarke@example.com', 'REPLACE_WITH_BCRYPT_HASH_07'),
    ('Conor', 'Murray', 'conor.murray', 'conor.murray@example.com', 'REPLACE_WITH_BCRYPT_HASH_08'),
    ('Mia', 'O''Brien', 'mia.obrien', 'mia.obrien@example.com', 'REPLACE_WITH_BCRYPT_HASH_09'),
    ('Ethan', 'Dunne', 'ethan.dunne', 'ethan.dunne@example.com', 'REPLACE_WITH_BCRYPT_HASH_10');
