insert into permissions(id,creationDate,lastModification,permission)
values(1,NOW(),NOW(),0);

insert into permissions(id,creationDate,lastModification,permission)
values(2,NOW(),NOW(),1);

insert into permissions(id,creationDate,lastModification,permission)
values(3,NOW(),NOW(),2);

insert into users(id,
creationDate,
lastModification,
active,
email,
name,
password)
values(1,
NOW(),
NOW(),
1,
'admin@meuponto.com.br',
'Jorge Sebastião Rodrigues Corrêa',
'$2a$10$at3enCRb/q.aUKAbus2FhecCU3NFgSmUi0MOgd1ffcWGepyfheckm');

insert into userPermissions(userId,permissionId) values(1,1);