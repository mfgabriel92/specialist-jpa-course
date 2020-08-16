INSERT INTO products (id, name, description, price) VALUES (1, 'Kindle', 'Discover the new Kindle, now with adjustable built-in lighting, which allows you to read indoors or out, anytime of the day.', 499.0);
INSERT INTO products (id, name, description, price) VALUES (2, 'Google Chromecast', 'Start streaming by speaking. Use your voice to stream from compatible apps, mute the volume, rewind, and more with Chromecast and Google Home.', 35.0);

INSERT INTO categories (id, name) VALUES (1, 'Electronics');

INSERT INTO clients (id, name) VALUES (1, 'Gabriel Fernandes');

INSERT INTO orders (id, apartment, city, neighborhood, number, postal_code, state, street, concluded_at, created_at, status, total, client_id) VALUES (1, null, null, null, null, null, null, null, null, UTC_TIMESTAMP, 'WAITING', 998.00, 1);
INSERT INTO orders (id, apartment, city, neighborhood, number, postal_code, state, street, concluded_at, created_at, status, total, client_id) VALUES (2, null, null, null, null, null, null, null, null, UTC_TIMESTAMP, 'WAITING', 499.00, 1);

INSERT INTO order_items (order_id, product_id, price, quantity) VALUES (1, 1, 499.00, 2);
INSERT INTO order_items (order_id, product_id, price, quantity) VALUES (2, 1, 499.00, 1);

INSERT INTO invoices (order_id, xml, created_at) VALUES (1, '<xml />', UTC_TIMESTAMP);
