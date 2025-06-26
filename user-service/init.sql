-- Create role table
CREATE TABLE IF NOT EXISTS role (
  role_name VARCHAR(255) PRIMARY KEY
);

-- Create users table with email
CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255),
  email VARCHAR(255)
);

-- Join table for users and roles
CREATE TABLE IF NOT EXISTS users_roles (
  users_id INT NOT NULL,
  roles_role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (users_id, roles_role_name),
  FOREIGN KEY (users_id) REFERENCES users(id),
  FOREIGN KEY (roles_role_name) REFERENCES role(role_name)
);

-- Insert roles
INSERT INTO role (role_name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

-- Insert test users with email
INSERT INTO users (username, password, email) VALUES
('aisha', '$2a$10$XdJgpUNXdVMLvkxftSXtEeV4nVy48PPg3GQLSYjUVfocg2uRkJEvm', '202201141@dau.ac.in'),  -- password: user123
('dev', '$2a$10$Pk8qTfTKYpQer8y.Xw8FxeUziGn0kAyOKwf7vSnViQGipF2q6hN3m', 'dev@example.com');        -- password: admin123

-- Map users to roles
INSERT INTO users_roles (users_id, roles_role_name)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');
