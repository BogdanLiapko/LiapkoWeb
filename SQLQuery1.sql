create database Dashboard
GO
use Dashboard
create table Users(

UserId int Primary key identity (1,1) not null,
Password nvarchar(50) not null,
UserName nvarchar(50) not null,
City nvarchar(50) not null,
Address nvarchar(50) not null,
Phone nvarchar(50) not null,
Permission int not null default(0)
)

create table Advertisment(

ProdId int Primary key identity (1,1) not null,
UserId int not null,
Header nvarchar(225) not null,
Description nvarchar(2000) not null,
Price decimal (9,2) not null,
Adress nvarchar(50) not null,
Categories nvarchar(2000) not null,
constraint FK_Advertisment_Users Foreign Key(UserId) references Users(UserId) on delete cascade on update cascade
)

create table Comments(

CommID int identity (1,1) Primary key not null,
Comm nvarchar(2000) not null
)

create table CommentsAdvertismentUsers(

CommId int not null,
UserId int not null,
ProdId int not null,
constraint PK_CommentsAdvertismentUsers primary key(UserId,ProdId,CommId),
constraint FK_CommentsAdvertismentUsers_Comments Foreign Key(CommId) references Comments(CommId) on delete cascade on update cascade,
constraint FK_CommentsAdvertismentUsers_Advertisment Foreign Key(ProdId) references Advertisment(ProdId) on delete cascade on update cascade,
constraint FK_CommentsAdvertismentUsers_Users Foreign Key(UserId) references Users(UserId)
)
