

For Servlet container 3.x, you can annotate the listener with @WebListener, no need to declares in web.xml.




WITH Servlet container 3.x
==========================

	@WebListener




NOT NEED:
=========

With Servlet container 3.0 is NOT necesari definition is in the web.xml

	<?xml version="1.0" encoding="UTF-8"?>
	<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns="http://java.sun.com/xml/ns/javaee"
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
		id="WebApp_ID" version="2.5">
		
		
		<listener>
			<listener-class>com.oiasso.init.ExampleServletContextListener</listener-class>
		</listener>
		
	</web-app>