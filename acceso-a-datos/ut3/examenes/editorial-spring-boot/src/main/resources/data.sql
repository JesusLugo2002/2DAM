-- Autores
INSERT INTO author (name, country) VALUES ('Gabriel García Márquez', 'Colombia');
INSERT INTO author (name, country) VALUES ('Isabel Allende', 'Chile');

-- Libros
INSERT INTO book (title, publication_year, author_id) VALUES ('Cien años de soledad', 1967, 1);
INSERT INTO book (title, publication_year, author_id) VALUES ('El coronel no tiene quien le escriba', 1961, 1);
INSERT INTO book (title, publication_year, author_id) VALUES ('La casa de los espíritus', 1982, 2);

-- Editoriales
INSERT INTO publisher (name, city) VALUES ('Editorial Sur', 'Madrid');
INSERT INTO publisher (name, city) VALUES ('Norte Libros', 'Barcelona');
