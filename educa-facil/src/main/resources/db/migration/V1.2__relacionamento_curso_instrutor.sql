ALTER TABLE tb_course ADD CONSTRAINT instrutor_fk FOREIGN KEY (instrutor_id) REFERENCES tb_user(id);