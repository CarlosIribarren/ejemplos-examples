<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
   <xsl:output method="xhtml" version="1.0" encoding="utf-8" indent="yes"/>
   
   <xsl:template match="/TEI.2/text/body">
      <html>
         <head>
            <title>Euskal Hiztegia</title>
         </head>
         <body bgcolor="yellow">
            <xsl:apply-templates/>
         </body>
      </html>
   </xsl:template>
   
   <xsl:template match="entry">
      <xsl:apply-templates />
   </xsl:template>
   

   <xsl:template match="entry/def">
      1 
      <xsl:value-of select="text()"/>
   </xsl:template>
   
   <xsl:template match="orth">
      <h2>
         <xsl:value-of select="text()"/>
      </h2>
   </xsl:template> 
   
   
   <xsl:template match="sense">
      <xsl:value-of select="@n"/>.
      <xsl:value-of select="def[text()]" />
   </xsl:template>
   <xsl:template match="pos">
      <b><xsl:value-of select="text()"/></b>
   </xsl:template>
   <xsl:template match="q">
...
   </xsl:template>
   <xsl:template match="xr">
...
      <xsl:apply-templates select="ref"/>
   </xsl:template>
   <xsl:template match="ref">
...
   </xsl:template>
   

   
   <!-- beste ezer behar dela uste baduzu, gehitu lasai!, baina ez ahaztu XSLTk badituela besterik ezeko erregelak ere -->

</xsl:stylesheet>
