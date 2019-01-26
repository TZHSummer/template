# Manual

### MySQL Config
```
CREATE SCHEMA `tshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'tshop'@'localhost' IDENTIFIED BY 'tshop@169.com';
GRANT ALL PRIVILEGES ON tshop.* TO 'tshop'@'localhost' WITH GRANT OPTION;
```
