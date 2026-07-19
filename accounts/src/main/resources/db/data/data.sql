-- =========================================
-- USERS
-- =========================================

INSERT INTO users(id,
                  email,
                  first_name,
                  last_name,
                  contact_number,
                  country_code,
                  password,
                  account_locked,
                  created_on)
VALUES ('usr_001',
        'john.doe@example.com',
        'John',
        'Doe',
        '1924217092109',
        '+91',
        '$2a$10$hashedpassword1',
        FALSE,
        '2026-01-10'),

       ('usr_002',
        'jane.smith@example.com',
        'Jane',
        'Smith', '1924217092109',
        '+91',
        '$2a$10$hashedpassword2',
        FALSE,
        '2026-01-11'),

       ('usr_003',
        'alice.wilson@example.com',
        'Alice',
        'Wilson',
        '1924217092109',
        '+91',
        '$2a$10$hashedpassword3',
        FALSE,
        '2026-01-12'),

       ('usr_004',
        'bob.brown@example.com',
        'Bob',
        'Brown',
        '1924217092109',
        '+91',
        '$2a$10$hashedpassword4',
        TRUE,
        '2026-01-15'),

       ('usr_005',
        'charlie.johnson@example.com',
        'Charlie',
        'Johnson',
        '1924217092109',
        '+91',
        '$2a$10$hashedpassword5',
        FALSE,
        '2026-01-16');


-- =========================================
-- WORKSPACES
-- =========================================

INSERT INTO shops(id,
                  shop_name,
                  owner_id,
                  created_on)
VALUES ('wrk_001',
        'Engineering Workspace',
        'usr_001',
        '2026-02-01'),
       ('wrk_002',
        'Marketing Workspace',
        'usr_002',
        '2026-02-03'),
       ('wrk_003',
        'Private Research',
        'usr_003',
        '2026-02-05'),
       ('wrk_004',
        'DevOps Workspace',
        'usr_001',
        '2026-02-06');

