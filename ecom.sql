PGDMP  .                    }         	   ecommerce    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    98358 	   ecommerce    DATABASE     �   CREATE DATABASE ecommerce WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE ecommerce;
                postgres    false            �            1259    114784 
   cart-items    TABLE     �   CREATE TABLE public."cart-items" (
    cart_id character varying(255) NOT NULL,
    created timestamp(6) without time zone,
    quantity integer NOT NULL,
    size character varying(255),
    product_id character varying(255) NOT NULL
);
     DROP TABLE public."cart-items";
       public         heap    postgres    false            �            1259    114771    products    TABLE     2  CREATE TABLE public.products (
    id character varying(255) NOT NULL,
    brand_name character varying(255),
    category_name character varying(255),
    created timestamp(6) without time zone,
    fit character varying(255),
    image1 character varying(255),
    image2 character varying(255),
    l_quantity integer NOT NULL,
    l_size boolean,
    m_quantity integer NOT NULL,
    m_size boolean,
    name character varying(255),
    offer_price character varying(255),
    price character varying(255),
    quantity integer NOT NULL,
    ratings integer NOT NULL,
    review double precision NOT NULL,
    s_quantity integer NOT NULL,
    s_size boolean,
    xl_quantity integer NOT NULL,
    xl_size boolean,
    xxl_quantity integer NOT NULL,
    xxl_size boolean,
    sub_category character varying(255)
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    114757    users    TABLE     �   CREATE TABLE public.users (
    id character varying(255) NOT NULL,
    created timestamp(6) without time zone,
    email character varying(255),
    password character varying(255),
    username character varying(255),
    role character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    114796    wishlist    TABLE     �   CREATE TABLE public.wishlist (
    wishlis_id character varying(255) NOT NULL,
    created timestamp(6) without time zone,
    product_id character varying(255) NOT NULL,
    user_id character varying(255) NOT NULL
);
    DROP TABLE public.wishlist;
       public         heap    postgres    false            �          0    114784 
   cart-items 
   TABLE DATA           T   COPY public."cart-items" (cart_id, created, quantity, size, product_id) FROM stdin;
    public          postgres    false    217   �       �          0    114771    products 
   TABLE DATA             COPY public.products (id, brand_name, category_name, created, fit, image1, image2, l_quantity, l_size, m_quantity, m_size, name, offer_price, price, quantity, ratings, review, s_quantity, s_size, xl_quantity, xl_size, xxl_quantity, xxl_size, sub_category) FROM stdin;
    public          postgres    false    216   �       �          0    114757    users 
   TABLE DATA           M   COPY public.users (id, created, email, password, username, role) FROM stdin;
    public          postgres    false    215   �!       �          0    114796    wishlist 
   TABLE DATA           L   COPY public.wishlist (wishlis_id, created, product_id, user_id) FROM stdin;
    public          postgres    false    218   R"       `           2606    114790    cart-items cart-items_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public."cart-items"
    ADD CONSTRAINT "cart-items_pkey" PRIMARY KEY (cart_id);
 H   ALTER TABLE ONLY public."cart-items" DROP CONSTRAINT "cart-items_pkey";
       public            postgres    false    217            ^           2606    114777    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    216            \           2606    114763    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    215            b           2606    114802    wishlist wishlist_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.wishlist
    ADD CONSTRAINT wishlist_pkey PRIMARY KEY (wishlis_id);
 @   ALTER TABLE ONLY public.wishlist DROP CONSTRAINT wishlist_pkey;
       public            postgres    false    218            d           2606    114803 $   wishlist fk6p7qhvy1bfkri13u29x6pu8au    FK CONSTRAINT     �   ALTER TABLE ONLY public.wishlist
    ADD CONSTRAINT fk6p7qhvy1bfkri13u29x6pu8au FOREIGN KEY (product_id) REFERENCES public.products(id);
 N   ALTER TABLE ONLY public.wishlist DROP CONSTRAINT fk6p7qhvy1bfkri13u29x6pu8au;
       public          postgres    false    4702    218    216            c           2606    114791 &   cart-items fk7onorwqn7sddwxla6119lmk2w    FK CONSTRAINT     �   ALTER TABLE ONLY public."cart-items"
    ADD CONSTRAINT fk7onorwqn7sddwxla6119lmk2w FOREIGN KEY (product_id) REFERENCES public.products(id);
 R   ALTER TABLE ONLY public."cart-items" DROP CONSTRAINT fk7onorwqn7sddwxla6119lmk2w;
       public          postgres    false    217    4702    216            e           2606    114808 $   wishlist fktrd6335blsefl2gxpb8lr0gr7    FK CONSTRAINT     �   ALTER TABLE ONLY public.wishlist
    ADD CONSTRAINT fktrd6335blsefl2gxpb8lr0gr7 FOREIGN KEY (user_id) REFERENCES public.users(id);
 N   ALTER TABLE ONLY public.wishlist DROP CONSTRAINT fktrd6335blsefl2gxpb8lr0gr7;
       public          postgres    false    4700    218    215            �   �   x��бq1��X[�5��@ `k�D)�#�?ce7��������`]xk��X}�Z��*TI�6 z�>�O��*?e�ia�:�cl�!�D�4M{^����C�d��N~ޠ�@Q�������(���r�TZD �gjR��nDΪ޴��>L���	L���p��l�����Z��]+���9=;�<�<��35gO��.�-s�S��^�`����'����G�V�G�ׇ���~��b�      �   4  x��[S�V��ů�Sގu��1�n.�t��J�Թڊ�D$9���ٲ�m�	);�S�LFZ������ǒd��ل-��&d��HQ!UA+��Y]�ɶӲ���XeS�0C��D	
< �fM�,�ɦ]���¶m�ځ�����/�c(m[�O��m�Ŧh�+�q�l
ܵ���F�K�阸������.;E
cI53��~��叟>_~y��-����;��ci�ԦY��n�y������o�e�q30&�f��`�g~�关��|u�u��d <p���G�:A��b�}����.f��2���ʪz����k,�R:J�p2I�9K�$�5�����1gDH�?rq��x,@r:��L'�1TP�9�eQ_lq��U~QN���)���C��)?��j3	dTO�eb�[ѱV+��D��t���A��� ��]:��t0�n����h�)X��9X�iL�$�'�A^���hJ��ߞ]�{c���7�����l3�󱭺6,�i~V����q�g��K4z�� ���!EBQ��!.-Aۀ4�&X�6O�EÇ�4��gC�]ݏ�X�h�E�D-5��`�`��"m)�����ɷ��O��������~���!Wx�,?�f�.b5�7�	]E?۫`̊_�3�.EE��'�9�3�)�e���Sp=������+��c�[9�������꠬�ꮃ��ß��$���������Uzn�5�D(�Xp�U�º�Yc1�A$��P̤��x���Cl��kl_z��Z����]M)|H��uGNHK��7e�0i��[ $E��v>�d4��PmD�����	p���z��MG���y����"�r�s:0>���G�zl�q�n�#��&+qx
U�e�qn�e��cE�.���I���b���:��D?b6��<�б"�{t�҆���&Xbo͇�j����in'1_�|�"(|���E7aFLO������C�?����g��
D�Q�[��G����(�v�kV��5-=d�9ͮ�E�.o��X����)P/���G.Ֆas����qZvw�^?ؕ6y�޶���̇ګl-���:_Te��u������h��*ag��׀�~���\��9�y�#Nqm�X{��W"�S�y�C~���`C�\�l���g��a{�L\|它��Z�4s^i'8���dM�=њH���<�J��u�[���������0���KFض���{0|̤���-0%h6J n�B.&�<0�k݇����������N8bH� �Nv��0*0���v����'���^+�a ѯ�27�3��zT�=L�~�������_P��8/��"N!�|4�j���i�`;��]�a��γ�e�Z� �@!\;c��<V�)鲫�q>:=��e'=�r@`���u�io���~]�0 k��.�Wx�CGuc��a��ߧ���E]W�)�]T�}�<�����C�Ō������,h�8���H-`���cd�c�V�5�0�JMU�ql�_U�D��e�bR ��U����&cM��t�����n�[������?�g8������m�&��-[�b�/nl+@.xn;�c+X�=c �qL@��2�K������OR=�����y��䓀����Nm�pҫ�."����S���t9w�Iӏ����>�B�.�Üe `�OQ��GL�ߊ(�E�C �B#jmT�\������dG����hy�Lc��:����)k=�ᔄ��Gv�9�I����>��m�>�͂�P{�P3j�s���fl���?�6��{`,���,�>�yptt�?Q�}%      �   d   x��A
�0 �s�
?��$�TO�/��"lV����f�Qƥ���T�3`1Vae鋣H	"Q�4�<R9;�v|�&�7�G{��n��l��:��� h�0      �   o   x�˹�0�X���@�8!���xg)�25�K����<�ûl���KHH!�a}x=$��^5��D0�zJ��7��<�\׌k�L��c$�����ܚ�����Z�aS!�     