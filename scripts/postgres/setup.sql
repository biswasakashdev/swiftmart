-- Create users
CREATE USER dev WITH PASSWORD 'devpassword';
CREATE USER test WITH PASSWORD 'testpassword';

-- Create databases
CREATE DATABASE swiftmart_core_dev_db OWNER dev;
CREATE DATABASE swiftmart_core_test_db OWNER test;

CREATE DATABASE swiftmart_orders_dev_db OWNER dev;
CREATE DATABASE swiftmart_orders_test_db OWNER test;

-- Optional: grant privileges

-- Grant access to dev user for test and dev database.
GRANT ALL PRIVILEGES ON DATABASE swiftmart_core_dev_db TO dev;
GRANT ALL PRIVILEGES ON DATABASE swiftmart_core_test_db TO test;


-- Grant access to test user for test and dev database.
GRANT ALL PRIVILEGES ON DATABASE swiftmart_orders_dev_db TO dev;
GRANT ALL PRIVILEGES ON DATABASE swiftmart_orders_test_db TO test;
