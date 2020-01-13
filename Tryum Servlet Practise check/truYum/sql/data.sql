/*Menu Item Table Details*/

INSERT INTO `truyum_sql`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'sandwich', '99.00', '0', '2020-01-12', 'Main Course', '1');
INSERT INTO `truyum_sql`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', '1', '2020-01-04', 'Main Course', '0');
INSERT INTO `truyum_sql`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', '1', '2020-01-10', 'Main Course', '0');
INSERT INTO `truyum_sql`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', '0', '2020-01-01', 'Starters', '1');
INSERT INTO `truyum_sql`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', '1', '2020-01-11', 'Dessert', '1');

/*User Details*/

INSERT INTO `truyum_sql`.`user` (`us_id`, `us_name`) VALUES ('1', 'vijay');
INSERT INTO `truyum_sql`.`user` (`us_id`, `us_name`) VALUES ('2', 'ajay');

/*cart table details*/

INSERT INTO `truyum_sql`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('1', '1', '5');
INSERT INTO `truyum_sql`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('2', '1', '3');
INSERT INTO `truyum_sql`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('3', '1', '5');


-- View Menu Item  List Admin
select * from truyum_sql.menu_item;

-- view menu item list customer
select * from truyum_sql.menu_item where me_active='1' and me_date_of_launch > (select curdate());

-- Edit menu item 
select * from truyum_sql.menu_item where me_id='1';

update truyum_sql.menu_item set me_name='Biriyani',me_price='50.00',me_active='0',me_date_of_launch='2020-01-12',me_category='Main Course',me_free_delivery='1'  where me_id='1';

-- view cart

select  me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum_sql.menu_item inner join truyum_sql.cart on ct_me_id = me_id where ct_us_id='1';

select  sum(me_price) as Total from truyum_sql.menu_item 
inner join cart 
on 
ct_me_id = me_id  
where ct_us_id='1';

delete  from truyum_sql.cart where ct_us_id='1' and ct_me_id='3' limit 1; 

select * from cart;
