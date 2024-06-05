drop table borrow_book,book,user;

CREATE TABLE book (
                      id INT(11) NOT NULL AUTO_INCREMENT,
                      name VARCHAR(100) NOT NULL,
                      author VARCHAR(100) NOT NULL,
                      publish_date DATE,
                      price DECIMAL(10, 2),
                      borrowed BOOLEAN DEFAULT 0,
                      update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)
);

CREATE TABLE user (
                      id INT(11) NOT NULL AUTO_INCREMENT,
                      username VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      PRIMARY KEY (id)
);

CREATE TABLE borrow_book (
                             id INT(11) NOT NULL AUTO_INCREMENT,
                             user_id INT(11) NOT NULL,
                             book_id INT(11) NOT NULL,
                             borrow_date DATE,
                             return_date DATE DEFAULT '1000-01-01',
                             PRIMARY KEY (id),
                             FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                             FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);



INSERT INTO book (name, author, publish_date, price)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 19.99),
    ('To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 24.99),
    ('1984', 'George Orwell', '1949-06-08', 22.99),
    ('Pride and Prejudice', 'Jane Austen', '1813-01-28', 18.99),
    ('The Catcher in the Rye', 'J.D. Salinger', '1951-07-16', 20.99),
    ('The Hobbit', 'J.R.R. Tolkien', '1937-09-21', 25.99),
    ('Moby Dick', 'Herman Melville', '1851-10-18', 17.99),
    ('War and Peace', 'Leo Tolstoy', '1869-01-01', 29.99),
    ('Crime and Punishment', 'Fyodor Dostoevsky', '1866-01-01', 21.99),
    ('The Brothers Karamazov', 'Fyodor Dostoevsky', '1880-01-01', 23.99),
    ('The Lord of the Rings', 'J.R.R. Tolkien', '1954-07-29', 27.99),
    ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', '1967-05-30', 26.99),
    ('Frankenstein', 'Mary Shelley', '1818-01-01', 18.99),
    ('Jane Eyre', 'Charlotte Bronte', '1847-10-16', 19.99),
    ('The Picture of Dorian Gray', 'Oscar Wilde', '1890-07-01', 20.99),
    ('The Alchemist', 'Paulo Coelho', '1988-01-01', 14.99),
    ('The Count of Monte Cristo', 'Alexandre Dumas', '1844-01-01', 22.99),
    ('The Little Prince', 'Antoine de Saint-Exupery', '1943-04-06', 12.99),
    ('To the Lighthouse', 'Virginia Woolf', '1927-05-05', 16.99),
    ('Brave New World', 'Aldous Huxley', '1932-01-01', 19.99),
    ('The Adventures of Tom Sawyer', 'Mark Twain', '1876-12-01', 14.99),
    ('Gone with the Wind', 'Margaret Mitchell', '1936-06-30', 21.99),
    ('Anna Karenina', 'Leo Tolstoy', '1877-01-01', 20.99),
    ('The Great Expectations', 'Charles Dickens', '1861-01-01', 18.99),
    ('The Scarlet Letter', 'Nathaniel Hawthorne', '1850-01-01', 17.99),
    ('Alice\'s Adventures in Wonderland', 'Lewis Carroll', '1865-11-26', 13.99),
    ('Don Quixote', 'Miguel de Cervantes', '1605-01-01', 23.99),
    ('The Grapes of Wrath', 'John Steinbeck', '1939-04-14', 22.99),
    ('The Divine Comedy', 'Dante Alighieri', '1320-01-01', 16.99),
    ('The Canterbury Tales', 'Geoffrey Chaucer', '1400-01-01', 15.99),
    ('Les Misérables', 'Victor Hugo', '1862-01-01', 19.99),
    ('Wuthering Heights', 'Emily Bronte', '1847-12-01', 18.99),
    ('The Sun Also Rises', 'Ernest Hemingway', '1926-10-22', 20.99),
    ('The Old Man and the Sea', 'Ernest Hemingway', '1952-09-01', 17.99);

INSERT INTO user (username, password)
VALUES
    ('cat', '123456'),
    ('dog', '123456'),
    ('pig', '123456'),
    ('tiger', '123456'),
    ('lion', '123456'),
    ('elephant', '123456'),
    ('monkey', '123456'),
    ('giraffe', '123456'),
    ('zebra', '123456');


INSERT INTO borrow_book (user_id, book_id, borrow_date, return_date)
VALUES
    (1, 1, '2023-05-10', '2023-05-20'),
    (2, 5, '2023-06-02', '2023-06-12'),
    (3, 9, '2023-07-15', '2023-07-25'),
    (4, 12, '2023-08-03', '2023-08-13'),
    (5, 18, '2023-09-18', '2023-09-28'),
    (6, 22, '2023-10-05', '2023-10-15'),
    (7, 28, '2023-11-09', '2023-11-19'),
    (8, 31, '2023-12-12', '2023-12-22'),
    (7, 7, '2024-01-02', '2024-01-12'),
    (8, 13, '2024-01-10', '2024-01-20'),
    (9, 7, '2024-01-18', '2024-01-28'),
    (9, 34, '2024-01-21', '2024-01-31'),
    (1, 13, '2024-02-01', '2024-02-11'),
    (2, 7, '2024-02-08', '2024-02-18'),
    (3, 13, '2024-02-15', '2024-02-25'),
    (1, 2, '2024-02-20', '2024-03-01'),
    (2, 6, '2024-02-25', '2024-03-06'),
    (3, 10, '2024-02-29', '2024-03-10');

INSERT INTO borrow_book (user_id, book_id, borrow_date)
VALUES
    (4, 13, '2024-03-05'),
    (5, 19, '2024-03-10'),
    (6, 23, '2024-03-15'),
    (6, 25, '2024-03-15');

UPDATE book set borrowed=true WHERE id=13;
UPDATE book set borrowed=true WHERE id=19;
UPDATE book set borrowed=true WHERE id=23;
UPDATE book set borrowed=true WHERE id=25;
# update borrow_book set return_date='2024-3-17' where book_id=19 and return_date='1000-01-01';

