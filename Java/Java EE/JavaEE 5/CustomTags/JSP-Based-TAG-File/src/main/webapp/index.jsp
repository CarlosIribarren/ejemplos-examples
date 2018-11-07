<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="oiasso" %>

<!doctype html>
<html lang="${springRequestContext.locale}">
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h1>JSP Based TAG files example</h1>
		
		<p>Tag files run only in JSP 2.0, whereas Java-based custom tags have a "classic" version that does not rely on the new SimpleTag API. So, if the container you are targeting is only compliant with earlier versions of the specification, you have to use classic Java-based custom tag development. The bad news is that classic Java-based custom tag development is quite more complicated than the SimpleTag API and we do not cover classic tags in this book. The good news is that almost all mainstream containers have been updated to be compliant with servlet specification 2.4 and JSP specification 2.0, so chances are you won't need to develop the classic Java-based custom tags.</p>

		<p>In general, there are two steps to creating a JSP-based custom tag.</p>
			<ul>
				<li>Create a JSP-based tag file. This file is a fragment of a JSP page with some special directives and a .tag extension. It must be placed inside the WEB-INF/tags directory or a subdirectory thereof.</li>
    			<li>Create a JSP page that uses the tag file. The JSP page points to the directory where the tag file resides. The name of the tag file (minus the .tag extension) becomes the name of the custom tag and therefore no TLD connecting the implementation of the tag with its name is needed.</li>
			</ul>
    		
		<oiasso:HolaMundoTag/>
		
	</body>
</html>