insert into ADDRESS (id, address_line1, address_line2, city, postal_code)
            values
            (1,'2792 Tincidunt Ave','Cartago','North Shore','161397'),
            (2,'Ap #791-9438 Vulputate, Av.','Antalya','Ang Mo Kio','32288'),
            (3,'Ap #628-4966 Volutpat. St.','Caraga','Wierde','97172'),
            (4,'781-5994 Ac Ave','Orenburg Oblast','Çaldıran','92641'),
            (5,'4634 Magna. St.','Queensland','Musakhel','151454');

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, medical_package)
            values
            (1,'Amaya','Berry','(058) 68876736','amaya.berry@google.com','31478','1985-08-29',TRUE),
            (2,'Kaitlin','Clay','(028) 87678244','clay.kaitlin@google.com','31656','2011-12-14',FALSE),
            (3,'Palmer','Curtis','(064) 33708215','palmer.curtis@outlook.com','34181','1989-11-28',FALSE),
            (4,'Ashton','Pate','(057) 48196857','pate_ashton4588@icloud.com','33168','2007-06-07',FALSE),
            (5,'Dennis','Solis','(003) 78238225','d.solis@outlook.com','01853','2021-09-04',TRUE);

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values
            (1,'Kevin','Ewing','(046) 89530196','ewingkevin@icloud.com','72397','SURGEON'),
            (2,'Cameron','Reese','(077) 78285687','reese_cameron@google.com','12686','GP'),
            (3,'Lani','Underwood','(060) 45717275','lunderwood@icloud.com','75637','DERMATOLOGIST'),
            (4,'Macaulay','Cunningham','(038) 88133351','macaulay-cunningham@google.com','16477','OCULIST'),
            (5,'Arthur','Dalton','(038) 55826888','arthur.dalton3719@google.com','78553','GP');

insert into visit (id, description, time)
            values
            (1,'eu nibh vulputate mauris sagittis placerat.', '2022-02-05 3:36:00'),
            (2,'ipsum sodales purus,','2019-05-21 3:36:00'),
            (3,'mi enim, condimentum eget,','2002-12-03 3:15:00'),
            (4,'non leo. Vivamus nibh dolor, nonummy ac, feugiat non,','1999-08-07 2:37:00'),
            (5,'Donec egestas. Duis ac arcu. Nunc mauris. Morbi','2024-05-09 6:32:00');

insert into medical_treatment (id, description, type)
            values
            (1,'risus quis diam luctus lobortis. Class aptent','USG'),
            (2,'neque. Nullam','EKG'),
            (3,'pharetra. Nam ac','RTG'),
            (4,'felis, adipiscing fringilla','RTG'),
            (5,'dolor','USG');
