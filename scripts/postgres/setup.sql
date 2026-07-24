-- Create users
CREATE USER dev WITH PASSWORD 'devpassword';
CREATE USER test WITH PASSWORD 'testpassword';

-- Create databases

-- Dev Instances
CREATE DATABASE swiftmart_accounts_dev OWNER dev;
CREATE DATABASE swiftmart_orders_dev OWNER dev;


-- Test Instances
CREATE DATABASE swiftmart_accounts_test OWNER test;
CREATE DATABASE swiftmart_orders_test OWNER test;

-- Optional: grant privileges

-- Grant access to dev user for test database.
GRANT ALL PRIVILEGES ON DATABASE swiftmart_accounts_dev TO dev;
GRANT ALL PRIVILEGES ON DATABASE swiftmart_orders_dev TO dev;


-- Grant access to test user for test databases.
GRANT ALL PRIVILEGES ON DATABASE swiftmart_accounts_test TO test;
GRANT ALL PRIVILEGES ON DATABASE swiftmart_orders_test TO test;
