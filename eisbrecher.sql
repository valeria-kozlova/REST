CREATE TABLE fines (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	car_number VARCHAR(9) NOT NULL,
	violator VARCHAR(90) NOT NULL,
	officer VARCHAR(90) NOT NULL,
	protocol_drafter VARCHAR(90) NOT NULL,
	protocol_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
	forfeit INT NOT NULL,
	court BOOLEAN DEFAULT FALSE,
	payed BOOLEAN DEFAULT FALSE
);

INSERT INTO fines (car_number, violator, officer, protocol_drafter, forfeit) VALUES
('Ъ123УЪ178', 'Нарушающий Нарушитель Нарушаевич', 'Кустов Оборотень Погонович', 'Состовляев Бумагомаратель', 500),
('Ъ123УЪ178', 'Нарушающий Нарушитель Нарушаевич', 'Кустов Оборотень Погонович', 'Состовляев Бумагомаратель', 800),
('Ъ123УЪ178', 'Нарушающий Нарушитель Нарушаевич', 'Кустов Оборотень Погонович', 'Состовляев Бумагомаратель', 1200);