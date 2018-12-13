# Spring_MybatisDemo
一、mybatis @Mapper 注解
二、mybatis,hibernate，分布式事务
三、CascadeType.PERSIST无法级联保存解决（https://blog.csdn.net/u012382571/article/details/50977185）： 


1、@OneToMany(cascade = {CascadeType.PERSIST}），发现级联不起作用，如果更改为Hibernate的注解 @Cascade({org.hibernate.annotations.CascadeType.PERSIST})，依然不起作用，但改为 @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})之后，注解生效。
原因如下：
如果使用javax.persistence.*里面的注解，只有调用相应的方法才生效，如PERSIST，只有调用persist方法才生效，Hibernate的注解也是如此。
查看我的代码，我保存对象用的是save方法，因此要用SAVE_UPDATE，级联才能生效。

2、使用方法
如果在ManyToOne的一端使用，如下（Vote类）：
@ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    private VoteSubject voteSubject;

那么在保存该Vote对象时，如果对象的voteSubject属性是一个新对象，则会在保存Vote对象时，顺便把voteSubject对象保存；反之，如果one2Many的一端如果没有设置关联，则one的一端保存时，不会保存集合中的新对象。

也就是说在哪个对象中的相应属性中设置了级联，那么在操作该对象时级联生效。
如果想让有关系的双方同时级联生效，那么级联要在两个对象中同时设置。
