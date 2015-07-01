# easyresearch-
This is a Conference Management System based on Springframework/hibernate and other latest web technologies. 
By using this system, the research papers can be submitted easily to the conferences.



DBCP configuration - ApacheTomcat7/mySql:
<Resource name="jdbc/easyresearch" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="javauser" password="javadude" driverClassName="com.mysql.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/javatest"/>
