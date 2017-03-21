<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0"
    xmlns="http://www.w3.org/1999/xhtml">
    <xsl:output method="xml" encoding="utf-8"/>
    <xsl:param name="sarreraHitza" />     
    <xsl:template match="/TEI.2/text/body"> 
      
        
        <xsl:copy-of select="entry[form/orth[text()= $sarreraHitza ] ]"/>
            
            
        
   
     </xsl:template>
</xsl:stylesheet>