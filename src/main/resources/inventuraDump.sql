--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.5 (Debian 14.5-1.pgdg110+1)

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
-- Name: inventura_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventura_table (
    id bigint NOT NULL,
    in_date bigint NOT NULL,
    name character varying(255),
    out_date character varying(255),
    price character varying(255),
    room character varying(255),
    state character varying(255) NOT NULL,
    type integer NOT NULL
);


ALTER TABLE public.inventura_table OWNER TO postgres;

--
-- Data for Name: inventura_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventura_table (id, in_date, name, out_date, price, room, state, type) FROM stdin;
\.


--
-- Name: inventura_table inventura_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventura_table
    ADD CONSTRAINT inventura_table_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--