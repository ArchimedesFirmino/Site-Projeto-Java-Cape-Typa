
INSERT INTO usuario (us_id, us_name, us_description, us_birthday, us_email, us_password, us_photo, us_status, us_type)
VALUES
  (1, 'João Silva', 'Estudante dedicado em busca do conhecimento.', '1990-01-15', 'joao.silva@example.com', 'senha123', 'https://picsum.photos/201', 'on', 'normal'),
  (2, 'Maria Souza', 'Interessada em ciências e tecnologia.', '1995-02-25', 'maria.souza@example.com', 'senha456', 'https://picsum.photos/199', 'on', 'normal'),
  (3, 'Pedro Almeida', 'Apaixonado por história e cultura.', '2000-03-10', 'pedro.almeida@example.com', 'senha789', 'https://picsum.photos/198', 'on', 'admin');

INSERT INTO artigo (ar_id, ar_date, ar_author, ar_title, ar_status, ar_thumbnail, ar_resume, ar_views, ar_content)
VALUES
  (6, '2023-07-06', 2, 'O Poder da Leitura', 'on', 'https://picsum.photos/203', 'Descubra como a leitura pode transformar vidas.', 120, 'A leitura é uma das atividades mais enriquecedoras que existem. Além de ampliar nosso conhecimento, ela nos transporta para mundos distintos, nos ensina lições valiosas e desenvolve nossa imaginação.'),
  (7, '2023-07-07', 3, 'Alimentação Saudável no Dia a Dia', 'on', 'https://picsum.photos/204', 'Dicas para uma alimentação equilibrada e saborosa.', 80, 'Manter uma alimentação saudável é essencial para o bem-estar físico e mental. Neste artigo, apresentamos dicas práticas para incorporar hábitos alimentares mais saudáveis em sua rotina, sem abrir mão do sabor.'),
  (8, '2023-07-08', 1, 'A Importância do Exercício Físico', 'on', 'https://picsum.photos/205', 'Como a atividade física influencia na qualidade de vida.', 150, 'Praticar exercícios físicos regularmente traz inúmeros benefícios à saúde. Além de fortalecer o corpo, eles ajudam a reduzir o estresse, melhoram a disposição e aumentam a sensação de bem-estar. Neste artigo, destacamos a importância de se manter ativo.'),
  (9, '2023-07-09', 3, 'Viajando pelo Mundo: Destinos Imperdíveis', 'on', 'https://picsum.photos/206', 'Conheça lugares surpreendentes ao redor do globo.', 250, 'Viajar é uma das experiências mais enriquecedoras que podemos viver. Neste artigo, apresentamos uma lista de destinos imperdíveis ao redor do mundo, repletos de paisagens deslumbrantes, cultura rica e aventuras emocionantes.'),
  (10, '2023-07-10', 1, 'Técnicas de Produtividade para o Dia a Dia', 'on', 'https://picsum.photos/207', 'Como otimizar seu tempo e aumentar a eficiência.', 40, 'Aumentar a produtividade é fundamental para realizar tarefas de forma mais eficiente e alcançar objetivos. Neste artigo, compartilhamos técnicas comprovadas que podem ajudá-lo a melhorar sua organização pessoal e aproveitar melhor o seu dia.');
  

INSERT INTO calendario (ca_id, ca_date, ca_author, ca_title, ca_status, ca_content, ca_institute, ca_views)
VALUES
  (1, '2023-07-01', 1, 'Vestibular A', 'on', '01/08/2023', 'Instituto Vestibular do Rio de Janeiro', 100),
  (2, '2023-07-02', 2, 'Vestibular B', 'on', '15/08/2023', 'Instituto de Ensino Superior do Rio de Janeiro', 50),
  (3, '2023-07-03', 1, 'Vestibular C', 'on', '20/08/2023', 'Centro Universitário do Rio de Janeiro', 75),
  (4, '2023-07-04', 3, 'Vestibular D', 'on', '02/09/2023', 'Universidade Estadual do Rio de Janeiro', 200),
  (5, '2023-07-05', 2, 'Vestibular E', 'on', '10/09/2023', 'Faculdade de Tecnologia do Rio de Janeiro', 30),
  (6, '2023-07-06', 1, 'Vestibular F', 'on', '15/09/2023', 'Instituto Vestibular do Rio de Janeiro', 60),
  (7, '2023-07-07', 3, 'Vestibular G', 'on', '25/09/2023', 'Instituto de Ensino Superior do Rio de Janeiro', 90);