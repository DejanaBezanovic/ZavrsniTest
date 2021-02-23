INSERT INTO `user` (id, username, password, role, email)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN', 'email3');
INSERT INTO `user` (id, username, password, role, email)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK', 'email' );
INSERT INTO `user` (id, username, password, role, email)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK', 'email1');

              
INSERT INTO formati (id, tip, broj) VALUES (1, 'Grand Slem', 500);
INSERT INTO formati (id, tip, broj) VALUES (2, 'Masters 1000', 500);
INSERT INTO formati (id, tip, broj) VALUES (3, 'Masters 500', 500);
INSERT INTO formati (id, tip, broj) VALUES (4, 'Masters 250', 500);

INSERT INTO takmicenje (id, naziv, mesto, datum_pocetka, datum_zavrsetka, format_id) 
   VALUES (1, 'Veliko', 'Los A' , '2020-06-21', '2020-06-27', 3);
 INSERT INTO takmicenje (id, naziv, mesto, datum_pocetka, datum_zavrsetka, format_id) 
   VALUES (2, 'Malo', 'Los A' , '2020-06-29', '2020-07-27', 1);
 INSERT INTO takmicenje (id, naziv, mesto, datum_pocetka, datum_zavrsetka, format_id) 
   VALUES (3, 'Ja', 'Los A' , '2020-06-29', '2020-07-27', 2);


INSERT INTO prijava (id, drzava, kontakt, datum_prijave, takmicenje_id) 
   VALUES (1, 'USD', 'email' , '2020-06-21', 2);
INSERT INTO prijava (id, drzava, kontakt, datum_prijave, takmicenje_id) 
   VALUES (2, 'RSD', 'email1' , '2020-06-21', 3);

