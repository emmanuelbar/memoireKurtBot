INSERT INTO kurtmemoire.politic
(id, firstname, lastname, party)
VALUES (nextval('kurtmemoire.politics_id_seq' :: REGCLASS), 'First name', 'Last Name', 'Party');

INSERT INTO kurtmemoire.conviction
(id, id_politic, libelle, "source")
VALUES (nextval('kurtmemoire.conviction_id_seq' :: REGCLASS), currval('kurtmemoire.politics_id_seq'), 'libelle',
        'url source');
-- don't forget to commit at the end
-- commit;
