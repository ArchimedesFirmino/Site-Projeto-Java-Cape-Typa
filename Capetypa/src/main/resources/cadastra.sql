
INSERT INTO usuario (us_id, us_name, us_description, us_birthday, us_email, us_password, us_photo, us_status, us_type)
VALUES
  (1, 'Usuário 1', 'Descrição do usuário 1', '1990-01-01', 'usuario1@example.com', 'senha1', 'https://picsum.photos/201', 'ativo', 'normal'),
  (2, 'Usuário 2', 'Descrição do usuário 2', '1995-02-02', 'usuario2@example.com', 'senha2', 'https://picsum.photos/199', 'ativo', 'normal'),
  (3, 'Usuário 3', 'Descrição do usuário 3', '2000-03-03', 'usuario3@example.com', 'senha3', 'https://picsum.photos/198', 'inativo', 'admin');

INSERT INTO artigo (ar_id, ar_date, ar_author, ar_title, ar_status, ar_thumbnail, ar_resume, ar_views, ar_content)
VALUES
  (1, '2023-07-01', 1, 'Título do Artigo 1', 'Publicado', 'https://picsum.photos/198', 'Resumo do artigo 1', 100, 'Conteúdo do artigo 1'),
  (2, '2023-07-02', 2, 'Título do Artigo 2', 'Rascunho', 'https://picsum.photos/199', 'Resumo do artigo 2', 50, 'Conteúdo do artigo 2'),
  (3, '2023-07-03', 1, 'Título do Artigo 3', 'Publicado', 'https://picsum.photos/200', 'Resumo do artigo 3', 75, 'Conteúdo do artigo 3'),
  (4, '2023-07-04', 3, 'Título do Artigo 4', 'Publicado', 'https://picsum.photos/201', 'Resumo do artigo 4', 200, 'Conteúdo do artigo 4'),
  (5, '2023-07-05', 2, 'Título do Artigo 5', 'Rascunho', 'https://picsum.photos/202', 'Resumo do artigo 5', 30, 'Conteúdo do artigo 5');

  

INSERT INTO calendario (ca_id, ca_date, ca_author, ca_title, ca_status, ca_content, ca_institute, ca_views)
VALUES
  (1, '2023-07-01', 1, 'Evento 1', 'Confirmado', 'Conteúdo do evento 1', 'Instituto 1', 100),
  (2, '2023-07-02', 2, 'Evento 2', 'Pendente', 'Conteúdo do evento 2', 'Instituto 2', 50),
  (3, '2023-07-03', 1, 'Evento 3', 'Confirmado', 'Conteúdo do evento 3', 'Instituto 1', 75),
  (4, '2023-07-04', 3, 'Evento 4', 'Cancelado', 'Conteúdo do evento 4', 'Instituto 3', 200),
  (5, '2023-07-05', 2, 'Evento 5', 'Confirmado', 'Conteúdo do evento 5', 'Instituto 2', 30),
  (6, '2023-07-06', 1, 'Evento 6', 'Pendente', 'Conteúdo do evento 6', 'Instituto 1', 60),
  (7, '2023-07-07', 3, 'Evento 7', 'Confirmado', 'Conteúdo do evento 7', 'Instituto 3', 90);
  