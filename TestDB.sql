PGDMP     #                    x           TestDB    12.2    12.2     )           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            *           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            +           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ,           1262    32769    TestDB    DATABASE     �   CREATE DATABASE "TestDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "TestDB";
                postgres    false            �            1259    32828    answers    TABLE     �   CREATE TABLE public.answers (
    id integer NOT NULL,
    correct_answer character varying(70),
    wrong_answer1 character varying(70),
    wrong_answer2 character varying(70),
    wrong_answer3 character varying(70)
);
    DROP TABLE public.answers;
       public         heap    postgres    false            �            1259    32822 	   questions    TABLE     _   CREATE TABLE public.questions (
    id integer NOT NULL,
    question character varying(70)
);
    DROP TABLE public.questions;
       public         heap    postgres    false            �            1259    32820    questions_id_seq    SEQUENCE     �   CREATE SEQUENCE public.questions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.questions_id_seq;
       public          postgres    false    207            -           0    0    questions_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.questions_id_seq OWNED BY public.questions.id;
          public          postgres    false    206            �            1259    32775    teacher_login    TABLE     �   CREATE TABLE public.teacher_login (
    id integer NOT NULL,
    password character varying(10),
    f_name character varying(20),
    l_name character varying(20)
);
 !   DROP TABLE public.teacher_login;
       public         heap    postgres    false            �            1259    32790    test    TABLE     x   CREATE TABLE public.test (
    id integer NOT NULL,
    question_id integer NOT NULL,
    answer_id integer NOT NULL
);
    DROP TABLE public.test;
       public         heap    postgres    false            �            1259    32805    user_grades    TABLE     �   CREATE TABLE public.user_grades (
    id integer NOT NULL,
    grade integer,
    test_id integer NOT NULL,
    user_id integer NOT NULL
);
    DROP TABLE public.user_grades;
       public         heap    postgres    false            �            1259    32770 
   user_login    TABLE     �   CREATE TABLE public.user_login (
    id integer NOT NULL,
    password character varying(10),
    f_name character varying(20),
    l_name character varying(20)
);
    DROP TABLE public.user_login;
       public         heap    postgres    false            �
           2604    32825    questions id    DEFAULT     l   ALTER TABLE ONLY public.questions ALTER COLUMN id SET DEFAULT nextval('public.questions_id_seq'::regclass);
 ;   ALTER TABLE public.questions ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            &          0    32828    answers 
   TABLE DATA           b   COPY public.answers (id, correct_answer, wrong_answer1, wrong_answer2, wrong_answer3) FROM stdin;
    public          postgres    false    208   E       %          0    32822 	   questions 
   TABLE DATA           1   COPY public.questions (id, question) FROM stdin;
    public          postgres    false    207   w       !          0    32775    teacher_login 
   TABLE DATA           E   COPY public.teacher_login (id, password, f_name, l_name) FROM stdin;
    public          postgres    false    203   �       "          0    32790    test 
   TABLE DATA           :   COPY public.test (id, question_id, answer_id) FROM stdin;
    public          postgres    false    204   �       #          0    32805    user_grades 
   TABLE DATA           B   COPY public.user_grades (id, grade, test_id, user_id) FROM stdin;
    public          postgres    false    205   �                  0    32770 
   user_login 
   TABLE DATA           B   COPY public.user_login (id, password, f_name, l_name) FROM stdin;
    public          postgres    false    202   �       .           0    0    questions_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.questions_id_seq', 2, true);
          public          postgres    false    206            �
           2606    32832    answers answers_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.answers
    ADD CONSTRAINT answers_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.answers DROP CONSTRAINT answers_pkey;
       public            postgres    false    208            �
           2606    32827    questions questions_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.questions DROP CONSTRAINT questions_pkey;
       public            postgres    false    207            �
           2606    32779     teacher_login teacher_login_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.teacher_login
    ADD CONSTRAINT teacher_login_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.teacher_login DROP CONSTRAINT teacher_login_pkey;
       public            postgres    false    203            �
           2606    32794    test test_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.test DROP CONSTRAINT test_pkey;
       public            postgres    false    204            �
           2606    32809    user_grades user_grades_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.user_grades
    ADD CONSTRAINT user_grades_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.user_grades DROP CONSTRAINT user_grades_pkey;
       public            postgres    false    205            �
           2606    32774    user_login user_login_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.user_login
    ADD CONSTRAINT user_login_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.user_login DROP CONSTRAINT user_login_pkey;
       public            postgres    false    202            �
           2606    32810 $   user_grades user_grades_test_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_grades
    ADD CONSTRAINT user_grades_test_id_fkey FOREIGN KEY (test_id) REFERENCES public.test(id);
 N   ALTER TABLE ONLY public.user_grades DROP CONSTRAINT user_grades_test_id_fkey;
       public          postgres    false    205    204    2713            �
           2606    32815 $   user_grades user_grades_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_grades
    ADD CONSTRAINT user_grades_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_login(id);
 N   ALTER TABLE ONLY public.user_grades DROP CONSTRAINT user_grades_user_id_fkey;
       public          postgres    false    2709    205    202            &   "   x�3�LLI����O���,N�,H,������ iH5      %       x�3�,��WH�Uȴ�2���=��b���� t<�      !      x������ � �      "      x������ � �      #      x������ � �             x������ � �     