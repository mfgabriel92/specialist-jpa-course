INSERT INTO products (id, name, description, price) VALUES (1, 'Kindle', 'Discover the new Kindle, now with adjustable built-in lighting, which allows you to read indoors or out, anytime of the day.', 499.0);
INSERT INTO products (id, name, description, price) VALUES (3, 'Google Chromecast', 'Start streaming by speaking. Use your voice to stream from compatible apps, mute the volume, rewind, and more with Chromecast and Google Home.', 35.0);

INSERT INTO clients (id, name) VALUES (1, 'Gabriel Fernandes');

INSERT INTO orders (id, apartment, city, neighborhood, number, postal_code, state, street, concluded_at, created_at, invoice_id, status, total, client_id) VALUES (1, null, null, null, null, null, null, null, null, UTC_TIMESTAMP, null, 'WAITING', 1497.00, 1);
INSERT INTO order_items (id, price, quantity, order_id, product_id) VALUES (1, 1497.00, 3, 1, 1);
