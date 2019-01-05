ALTER USER 'tshop'@'localhost' IDENTIFIED WITH mysql_native_password BY 'tshop@169.com';
GRANT ALL ON *.* TO 'tshop'@'localhost';
FLUSH PRIVILEGES;