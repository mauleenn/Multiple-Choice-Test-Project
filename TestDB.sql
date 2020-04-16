--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-16 16:59:56

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
-- TOC entry 205 (class 1259 OID 32785)
-- Name: answers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.answers (
    id integer NOT NULL,
    answer character varying(30)
);


ALTER TABLE public.answers OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32780)
-- Name: questions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.questions (
    id integer NOT NULL,
    question character varying(30)
);


ALTER TABLE public.questions OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 32775)
-- Name: teacher_login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teacher_login (
    id integer NOT NULL,
    password character varying(10),
    f_name character varying(20),
    l_name character varying(20)
);


ALTER TABLE public.teacher_login OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 32790)
-- Name: test; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.test (
    id integer NOT NULL,
    question_id integer NOT NULL,
    answer_id integer NOT NULL
);


ALTER TABLE public.test OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 32805)
-- Name: user_grades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_grades (
    id integer NOT NULL,
    grade integer,
    test_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.user_grades OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32770)
-- Name: user_login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_login (
    id integer NOT NULL,
    password character varying(10),
    f_name character varying(20),
    l_name character varying(20)
);


ALTER TABLE public.user_login OWNER TO postgres;

--
-- TOC entry 2850 (class 0 OID 32785)
-- Dependencies: 205
-- Data for Name: answers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.answers (id, answer) FROM stdin;
\.


--
-- TOC entry 2849 (class 0 OID 32780)
-- Dependencies: 204
-- Data for Name: questions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.questions (id, question) FROM stdin;
10	Simpson
11	Who are the simpsons?
\.


--
-- TOC entry 2848 (class 0 OID 32775)
-- Dependencies: 203
-- Data for Name: teacher_login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teacher_login (id, password, f_name, l_name) FROM stdin;
\.


--
-- TOC entry 2851 (class 0 OID 32790)
-- Dependencies: 206
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.test (id, question_id, answer_id) FROM stdin;
\.


--
-- TOC entry 2852 (class 0 OID 32805)
-- Dependencies: 207
-- Data for Name: user_grades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_grades (id, grade, test_id, user_id) FROM stdin;
\.


--
-- TOC entry 2847 (class 0 OID 32770)
-- Dependencies: 202
-- Data for Name: user_login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_login (id, password, f_name, l_name) FROM stdin;
\.


--
-- TOC entry 2712 (class 2606 OID 32789)
-- Name: answers answers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answers
    ADD CONSTRAINT answers_pkey PRIMARY KEY (id);


--
-- TOC entry 2710 (class 2606 OID 32784)
-- Name: questions questions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 32779)
-- Name: teacher_login teacher_login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher_login
    ADD CONSTRAINT teacher_login_pkey PRIMARY KEY (id);


--
-- TOC entry 2714 (class 2606 OID 32794)
-- Name: test test_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 32809)
-- Name: user_grades user_grades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_grades
    ADD CONSTRAINT user_grades_pkey PRIMARY KEY (id);


--
-- TOC entry 2706 (class 2606 OID 32774)
-- Name: user_login user_login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login
    ADD CONSTRAINT user_login_pkey PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 32800)
-- Name: test test_answer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_answer_id_fkey FOREIGN KEY (answer_id) REFERENCES public.answers(id);


--
-- TOC entry 2717 (class 2606 OID 32795)
-- Name: test test_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.questions(id);


--
-- TOC entry 2719 (class 2606 OID 32810)
-- Name: user_grades user_grades_test_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_grades
    ADD CONSTRAINT user_grades_test_id_fkey FOREIGN KEY (test_id) REFERENCES public.test(id);


--
-- TOC entry 2720 (class 2606 OID 32815)
-- Name: user_grades user_grades_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_grades
    ADD CONSTRAINT user_grades_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_login(id);


-- Completed on 2020-04-16 16:59:56

--
-- PostgreSQL database dump complete
--

