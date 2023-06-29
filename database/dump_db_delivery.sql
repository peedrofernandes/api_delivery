--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: adicional; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adicional (
    id_adicional integer NOT NULL,
    nome character varying(40),
    valor double precision,
    id_refeicao integer
);


ALTER TABLE public.adicional OWNER TO postgres;

--
-- Name: adicional_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adicional_pedido (
    id_adicional integer NOT NULL,
    id_pedido integer NOT NULL,
    quantidade integer
);


ALTER TABLE public.adicional_pedido OWNER TO postgres;

--
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    nome character varying(40) NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- Name: categoria_estab; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria_estab (
    nome character varying(40) NOT NULL,
    cnpj numeric(14,0) NOT NULL
);


ALTER TABLE public.categoria_estab OWNER TO postgres;

--
-- Name: estabelecimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estabelecimento (
    cnpj numeric(14,0) NOT NULL,
    nome character varying(40),
    cpf numeric(11,0),
    rua character varying(64),
    bairro character varying(32),
    cidade character varying(32)
);


ALTER TABLE public.estabelecimento OWNER TO postgres;

--
-- Name: metodopagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.metodopagamento (
    cod_metodo integer NOT NULL,
    tipo character varying(20)
);


ALTER TABLE public.metodopagamento OWNER TO postgres;

--
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id_pedido integer NOT NULL,
    valor_final double precision,
    taxa_de_entrega double precision,
    status character varying(15),
    observacao character varying(200),
    cpf numeric(11,0),
    cod_metodo integer
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- Name: pedido_refeicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_refeicao (
    id_refeicao integer NOT NULL,
    id_pedido integer NOT NULL,
    quantidade integer
);


ALTER TABLE public.pedido_refeicao OWNER TO postgres;

--
-- Name: refeicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.refeicao (
    id_refeicao integer NOT NULL,
    valor double precision,
    nome character varying(40),
    cnpj numeric(14,0)
);


ALTER TABLE public.refeicao OWNER TO postgres;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    cpf numeric(11,0) NOT NULL,
    nome character varying(40),
    email character varying(50)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Data for Name: adicional; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adicional (id_adicional, nome, valor, id_refeicao) FROM stdin;
1	Queijo Parmesão	5	1
2	Borda Recheada	8	2
3	Tempurá de Legumes	6	3
4	Bacon	4	4
5	Chantilly	3	5
\.


--
-- Data for Name: adicional_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adicional_pedido (id_adicional, id_pedido, quantidade) FROM stdin;
1	1	1
2	1	2
3	2	1
4	3	2
4	4	1
\.


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (nome) FROM stdin;
Italiana
Pizza
Japonesa
Hamburgueria
Cafeteria
\.


--
-- Data for Name: categoria_estab; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria_estab (nome, cnpj) FROM stdin;
Italiana	12345678901234
Pizza	23456789012345
Japonesa	34567890123456
Italiana	45678901234567
Hamburgueria	56789012345678
Cafeteria	67890123456789
\.


--
-- Data for Name: estabelecimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estabelecimento (cnpj, nome, cpf, rua, bairro, cidade) FROM stdin;
12345678901234	Restaurante do Chef	12345678901	Rua Principal	Centro	São Paulo
23456789012345	Pizzaria Bella Napoli	23456789012	Avenida da Praia	Beira-Mar	Rio de Janeiro
34567890123456	Sushi House	34567890123	Rua Comercial	Centro	Belo Horizonte
45678901234567	Cantina Italia	45678901234	Rua das Flores	Bairro Novo	Curitiba
56789012345678	Burger Joint	56789012345	Avenida do Lanche	Centro	São Paulo
67890123456789	Cafeteria Aroma	67890123456	Rua do Café	Bairro Industrial	Porto Alegre
\.


--
-- Data for Name: metodopagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.metodopagamento (cod_metodo, tipo) FROM stdin;
1	Cartão de Crédito
2	Boleto Bancário
3	Transferência
\.


--
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (id_pedido, valor_final, taxa_de_entrega, status, observacao, cpf, cod_metodo) FROM stdin;
1	58	10	Em andamento	Adicionar pimenta extra	12345678901	1
2	30	5	Concluído	Entregar na portaria	23456789012	2
3	50	8	Em andamento	Ligar antes de entregar	34567890123	3
4	50	7	Concluído	Deixar na recepção	45678901234	1
5	42	6	Pendente	Sem cebola, por favor	56789012345	2
6	65	9	Em andamento	Entregar no escritório 302	67890123456	3
7	22	4	Concluído	Retirar talheres de plástico	12345678901	1
8	38	7	Pendente	Pedido urgente	23456789012	2
9	50	8	Em andamento	Entrar pela porta dos fundos	34567890123	3
10	20	3	Concluído	Adicionar molho extra	45678901234	1
\.


--
-- Data for Name: pedido_refeicao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_refeicao (id_refeicao, id_pedido, quantidade) FROM stdin;
1	1	2
6	1	1
3	2	3
4	3	1
4	4	2
1	5	5
6	5	1
\.


--
-- Data for Name: refeicao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.refeicao (id_refeicao, valor, nome, cnpj) FROM stdin;
1	30	Espaguete à Bolonhesa	12345678901234
2	25	Pizza Margherita	23456789012345
3	20	Combo Sushi	34567890123456
4	40	X-Burger Clássico	56789012345678
5	15	Café Espresso	67890123456789
6	18	Lasanha à Bolonhesa	12345678901234
7	22	Calzone Quatro Queijos	23456789012345
8	32	Combo Sashimi	34567890123456
9	15	Vegetariano Burger	56789012345678
10	12	Café Latte	67890123456789
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (cpf, nome, email) FROM stdin;
12345678901	João Silva	joao.silva@example.com
23456789012	Maria Santos	maria.santos@example.com
34567890123	Pedro Rocha	pedro.rocha@example.com
45678901234	Ana Oliveira	ana.oliveira@example.com
56789012345	Mariana Costa	mariana.costa@example.com
67890123456	Lucas Almeida	lucas.almeida@example.com
\.


--
-- Name: adicional_pedido adicional_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adicional_pedido
    ADD CONSTRAINT adicional_pedido_pkey PRIMARY KEY (id_adicional, id_pedido);


--
-- Name: adicional adicional_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adicional
    ADD CONSTRAINT adicional_pkey PRIMARY KEY (id_adicional);


--
-- Name: categoria_estab categoria_estab_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_estab
    ADD CONSTRAINT categoria_estab_pkey PRIMARY KEY (nome, cnpj);


--
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (nome);


--
-- Name: estabelecimento estabelecimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estabelecimento
    ADD CONSTRAINT estabelecimento_pkey PRIMARY KEY (cnpj);


--
-- Name: metodopagamento metodopagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.metodopagamento
    ADD CONSTRAINT metodopagamento_pkey PRIMARY KEY (cod_metodo);


--
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido);


--
-- Name: pedido_refeicao pedido_refeicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_refeicao
    ADD CONSTRAINT pedido_refeicao_pkey PRIMARY KEY (id_refeicao, id_pedido);


--
-- Name: refeicao refeicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refeicao
    ADD CONSTRAINT refeicao_pkey PRIMARY KEY (id_refeicao);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (cpf);


--
-- Name: adicional adicional_id_refeicao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adicional
    ADD CONSTRAINT adicional_id_refeicao_fkey FOREIGN KEY (id_refeicao) REFERENCES public.refeicao(id_refeicao);


--
-- Name: adicional_pedido adicional_pedido_id_adicional_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adicional_pedido
    ADD CONSTRAINT adicional_pedido_id_adicional_fkey FOREIGN KEY (id_adicional) REFERENCES public.adicional(id_adicional);


--
-- Name: adicional_pedido adicional_pedido_id_pedido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adicional_pedido
    ADD CONSTRAINT adicional_pedido_id_pedido_fkey FOREIGN KEY (id_pedido) REFERENCES public.pedido(id_pedido);


--
-- Name: categoria_estab categoria_estab_cnpj_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_estab
    ADD CONSTRAINT categoria_estab_cnpj_fkey FOREIGN KEY (cnpj) REFERENCES public.estabelecimento(cnpj);


--
-- Name: categoria_estab categoria_estab_nome_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_estab
    ADD CONSTRAINT categoria_estab_nome_fkey FOREIGN KEY (nome) REFERENCES public.categoria(nome);


--
-- Name: estabelecimento estabelecimento_cpf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estabelecimento
    ADD CONSTRAINT estabelecimento_cpf_fkey FOREIGN KEY (cpf) REFERENCES public.usuario(cpf);


--
-- Name: pedido pedido_cod_metodo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_cod_metodo_fkey FOREIGN KEY (cod_metodo) REFERENCES public.metodopagamento(cod_metodo);


--
-- Name: pedido pedido_cpf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_cpf_fkey FOREIGN KEY (cpf) REFERENCES public.usuario(cpf);


--
-- Name: pedido_refeicao pedido_refeicao_id_pedido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_refeicao
    ADD CONSTRAINT pedido_refeicao_id_pedido_fkey FOREIGN KEY (id_pedido) REFERENCES public.pedido(id_pedido);


--
-- Name: pedido_refeicao pedido_refeicao_id_refeicao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_refeicao
    ADD CONSTRAINT pedido_refeicao_id_refeicao_fkey FOREIGN KEY (id_refeicao) REFERENCES public.refeicao(id_refeicao);


--
-- Name: refeicao refeicao_cnpj_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refeicao
    ADD CONSTRAINT refeicao_cnpj_fkey FOREIGN KEY (cnpj) REFERENCES public.estabelecimento(cnpj);


--
-- PostgreSQL database dump complete
--

