create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
alter table public.student add column password varchar(255)
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), password varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table ActualJob (id  bigserial not null, description varchar(255), name varchar(255), workplace_id int8, primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Klass (id  bigserial not null, name varchar(255), primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table Message (id  bigserial not null, textMessage varchar(255), receiver_id int8, sender_id int8, primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table School (id  bigserial not null, location varchar(255), primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), password varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Student (id  bigserial not null, email varchar(255), name varchar(255), password varchar(255), phonenumber varchar(255), workplaceFeedback varchar(255), klass_id int8, workplace_id int8, primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
create table Workplace (id  bigserial not null, description varchar(255), name varchar(255), primary key (id))
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table ActualJob add constraint FKsrs2gdr2erivq4q4f85y5ls7v foreign key (workplace_id) references Workplace
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FK6p3nfecpdhqemc3956wom1qbl foreign key (receiver_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Message add constraint FKk97pu7g6klvlih8xb75xb5m7p foreign key (sender_id) references Student
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
alter table Student add constraint FKt6gnpaxnx9cm4x1os2t936fsm foreign key (klass_id) references Klass
alter table Student add constraint FKcgqfnhy6eu7j1bg0mrcon06hh foreign key (workplace_id) references Workplace
