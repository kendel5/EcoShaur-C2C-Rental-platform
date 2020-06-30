load data infile 'post.csv'
insert
into table zipcode
fields terminated by ','
trailing nullcols
(zipcode,sido,gugun,dong,li,bunji,etc)