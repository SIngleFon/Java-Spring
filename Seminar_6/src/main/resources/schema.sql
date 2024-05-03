create table notes (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(50) NOT NULL,
                         content varchar(288) NOT NULL,
                         created TIME
);